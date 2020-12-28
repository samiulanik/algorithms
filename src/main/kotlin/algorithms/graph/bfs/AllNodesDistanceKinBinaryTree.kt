package algorithms.graph.bfs

import algorithms.tree.TreeNode
import java.util.LinkedList
import java.util.Queue

fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
    val adjMap: MutableMap<TreeNode, MutableSet<TreeNode>> = mutableMapOf()
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    val visited: MutableMap<TreeNode, Boolean> = mutableMapOf()

    while (queue.isNotEmpty()) {
        var size = queue.size
        while (size > 0) {
            val current = queue.poll()
            if (adjMap[current] == null) {
                adjMap[current] = mutableSetOf()
                visited[current] = false
            }
            if (current.left != null) {
                if (adjMap[current.left!!] == null) {
                    adjMap[current.left!!] = mutableSetOf()
                    visited[current.left!!] = false
                }
                adjMap[current]?.add(current.left!!)
                adjMap[current.left!!]?.add(current)
                queue.add(current.left)
            }

            if (current.right != null) {
                if (adjMap[current.right!!] == null) {
                    adjMap[current.right!!] = mutableSetOf()
                    visited[current.right!!] = false
                }
                adjMap[current]?.add(current.right!!)
                adjMap[current.right!!]?.add(current)
                queue.add(current.right)
            }
            size--
        }
    }

    queue.add(target)
    visited[target!!] = true
    var level = 0
    while (queue.isNotEmpty()) {
        var size = queue.size
        if (level == K) {
            return queue.map { it.`val` }
        }
        while (size > 0) {
            val current = queue.poll()
            visited[current!!] = true
            adjMap[current]?.forEach {
                if (visited[it] == false) queue.add(it)
            }
            size--
        }
        level++
    }
    return listOf()
}

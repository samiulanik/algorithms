package algorithms.tree

import java.util.LinkedList
import java.util.Queue

// 226. Invert Binary Tree

fun invertTree(root: TreeNode?): TreeNode? {
    val queue: Queue<TreeNode> = LinkedList()
    if (root == null) return null
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        (1..size).forEach { _ ->
            val node = queue.poll()
            val right = node.right
            node.right = node.left
            node.left = right
            if (node.left != null) queue.offer(node.left)
            if (node.right != null) queue.offer(node.right)
        }
    }

    return root
}

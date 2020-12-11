package algorithms.tree

// leetcode

fun bstToGst(root: TreeNode?): TreeNode? {
    reversedInorder(root, 0)
    return root
}

fun reversedInorder(node: TreeNode?, sum: Int): Int {
    if (node == null) {
        return sum
    }
    node.`val` += reversedInorder(node.right, sum) // recurse to right subtree.
    return reversedInorder(node.left, node.`val`) // recurse to left subtree.
}

package algorithms.tree

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val leftDepth = maxDepth(root.left)
    val rightDepth = maxDepth(root.right)
    return if (leftDepth > rightDepth) leftDepth + 1 else rightDepth + 1
}

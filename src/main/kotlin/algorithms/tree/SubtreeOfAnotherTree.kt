package algorithms.tree

fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
    return when {
        s == null -> false
        isSameTree(s, t) -> true
        else -> isSubtree(s.left, t) || isSubtree(s.right, t)
    }
}

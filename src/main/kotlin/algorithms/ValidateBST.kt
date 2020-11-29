package algorithms

import java.lang.Double.NEGATIVE_INFINITY
import java.lang.Double.POSITIVE_INFINITY

fun isValidBST(root: TreeNode?): Boolean {
    return BSTUtil(root, NEGATIVE_INFINITY, POSITIVE_INFINITY)
}

fun BSTUtil(root: TreeNode?, min: Double, max: Double): Boolean {
    if (root == null) return true
    return if (root.`val` <= min || root.`val` >= max) false
    else BSTUtil(root.left, min, root.`val`.toDouble()) &&
        BSTUtil(root.right, root.`val`.toDouble(), max)
}

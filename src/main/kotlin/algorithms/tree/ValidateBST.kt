package algorithms.tree

import java.lang.Integer.MAX_VALUE
import java.lang.Integer.MIN_VALUE

fun isValidBST(root: TreeNode?): Boolean {
    return BSTUtil(root, MIN_VALUE, MAX_VALUE)
}

fun BSTUtil(root: TreeNode?, min: Int, max: Int): Boolean {
    if (root == null) return true
    return if (root.`val` <= min || root.`val` >= max) false
    else BSTUtil(root.left, min, root.`val`) &&
        BSTUtil(root.right, root.`val`, max)
}

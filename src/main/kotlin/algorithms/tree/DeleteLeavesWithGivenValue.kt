package algorithms.tree

fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    if (root!!.left != null) root.left = removeLeafNodes(root.left, target)
    if (root.right != null) root.right = removeLeafNodes(root.right, target)
    return if (root.left === root.right && root.`val` === target) null else root
}

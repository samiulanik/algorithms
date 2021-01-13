package algorithms.tree

fun pathSum(root: TreeNode?, sum: Int): Int {
    if (root == null) return 0
    return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
}

fun findPath(node: TreeNode?, sum: Int): Int {
    if (node == null) return 0

    var res = 0
    if (node.`val` == sum) res += 1

    res += findPath(node.left, sum - node.`val`)
    res += findPath(node.right, sum - node.`val`)

    return res
}

// 1,-2,-3,1,3,-2,null,-1

package algorithms.tree

// 1373. Maximum Sum BST in Binary Tree

var max = 0
fun maxSumBST(root: TreeNode?): Int {
    max = 0
    findMaxSum(root)
    return max
}

fun findMaxSum(node: TreeNode?): IntArray {
    if (node == null) {
        return intArrayOf(1, Int.MIN_VALUE, Int.MAX_VALUE, 0)
    }
    val left = findMaxSum(node.left)
    val right = findMaxSum(node.right)
    val isBST = left[0] == 1 && right[0] == 1 && node.`val` > left[1] && node.`val` < right[2]
    val sum = node.`val` + left[3] + right[3]
    if (isBST) {
        max = max.coerceAtLeast(sum)
    }
    return intArrayOf(
        if (isBST) 1 else 0, node.`val`.coerceAtLeast(right[1]),
        node.`val`.coerceAtMost(left[2]),
        sum
    )
}

package algorithms.trie

data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf(),
    var content: String? = null,
    var isWord: Boolean = false
)

fun trieInsert(root: TrieNode, word: String) {
    var node = root
    word.forEach {
        node.children.putIfAbsent(it, TrieNode())
        node = node.children[it]!!
    }
    node.isWord = true
}

package algorithms.trie

data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf(),
    var content: String? = null,
    var isWord: Boolean = false
)

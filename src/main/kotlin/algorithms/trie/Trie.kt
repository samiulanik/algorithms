package algorithms.trie

// 208. Implement Trie (Prefix Tree)

class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        word.forEach {
            node.children.putIfAbsent(it, TrieNode())
            node = node.children[it]!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        val node = root
        return searchWord(node, word, 0)
    }

    private fun searchWord(node: TrieNode, word: String, pos: Int, isPrefixSearch: Boolean = false): Boolean {
        if (word.length == pos) return isPrefixSearch || node.isWord
        val ch = word[pos]
        return when {
            node.children[ch] != null -> searchWord(node.children[ch]!!, word, pos + 1, isPrefixSearch)
            else -> false
        }
    }

    fun startsWith(prefix: String): Boolean {
        val node = root
        return searchWord(node, prefix, 0, true)
    }
}

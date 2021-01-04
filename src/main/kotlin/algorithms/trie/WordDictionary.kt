package algorithms.trie

// 211. Design Add and Search Words Data Structure

class WordDictionary {
    private val root = TrieNode()

    fun addWord(word: String) {
        var node = root
        word.forEach {
            node.children.putIfAbsent(it, TrieNode())
            node = node.children[it]!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        return searchWord(node, word, 0)
    }

    private fun searchWord(node: TrieNode, word: String, pos: Int): Boolean {
        if (pos == word.length) return node.isWord
        val ch = word[pos]
        val children = node.children
        when {
            ch == '.' -> {
                children.forEach {
                    if (searchWord(it.value, word, pos + 1)) return true
                }
            }
            children[ch] != null -> return searchWord(children[ch]!!, word, pos + 1)
            else -> return false
        }
        return false
    }
}

package algorithms.trie

// 472. Concatenated Words

fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
    val root = TrieNode()
    words.forEach { trieInsert(root, it) }
    return words.filter {
        isCompoundWord(root, it, 0, 0, mutableMapOf())
    }
}

fun isCompoundWord(node: TrieNode, word: String, index: Int, count: Int, map: MutableMap<String, Boolean>): Boolean {
    if (index == word.length) {
        return count > 1
    }

    val next: String = word.substring(index)
    if (map.containsKey(next)) {
        return map[next]!!
    }

    var current = node
    for (i in index until word.length) {
        val c: Char = word[i]
        if (!current.children.containsKey(c)) {
            map[next] = false
            return false
        }
        current = current.children[c]!!
        if (current.isWord) {
            if (isCompoundWord(node, word, i + 1, count + 1, map)) {
                map[next] = true
                return true
            }
        }
    }
    map[next] = false
    return false
}

fun main() {
    println(findAllConcatenatedWordsInADict(listOf("cat", "cats", "catsdogcats", "dog").toTypedArray()))
}

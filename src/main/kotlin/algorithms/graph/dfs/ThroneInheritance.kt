package algorithms.graph.dfs

// 1600. Throne Inheritance

class ThroneInheritance(private val kingName: String) {
    private val successorMap = mutableMapOf<String, MutableList<String>>()
    private val statusMap = mutableMapOf<String, Boolean>()

    init {
        successorMap[kingName] = mutableListOf()
        statusMap[kingName] = true
    }

    fun birth(parentName: String, childName: String) {
        successorMap[parentName]?.add(childName)
        successorMap[childName] = mutableListOf()
        statusMap[childName] = true
    }

    fun death(name: String) {
        statusMap[name] = false
    }

    private fun addSuccessor(name: String, result: LinkedHashSet<String>) {
        val successors = successorMap[name]!!
        result.add(name)
        successors.forEach {
            if (statusMap[it]!!) result.add(it)
            addSuccessor(it, result)
        }
    }

    fun getInheritanceOrder(): List<String> {
        val result = LinkedHashSet<String>()
        addSuccessor(kingName, result)
        return result.toList()
    }
}

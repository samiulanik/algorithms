package algorithms.randomizeDataStructure

import java.util.Random

// 381. Insert Delete GetRandom O(1) - Duplicates allowed

class RandomizedCollection {
    var map: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    var list: MutableList<Int> = mutableListOf()
    var random = Random()

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        val exist = map.contains(`val`)
        map.getOrPut(`val`, { LinkedHashSet() }).add(list.size)
        list.add(`val`)

        return !exist
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (map[`val`] == null) return false
        val pos = map[`val`]!!.first()
        map[`val`]!!.remove(pos)

        list[pos] = list[list.size - 1]
        map[list[pos]]!!.add(pos)

        // must remove the swapped value index.
        map[list[pos]]!!.remove(list.size - 1)
        list.removeAt(list.size - 1)
        if (map[`val`]!!.isEmpty()) {
            map.remove(`val`)
        }
        return true
    }

    /** Get a random element from the collection. */
    fun getRandom(): Int {
        return list[random.nextInt(list.size)]
    }
}

fun main() {
    val r = RandomizedCollection()
    r.insert(0)
    r.insert(1)
    r.remove(0)
    r.insert(2)
    r.remove(1)
    println(r.getRandom())
}

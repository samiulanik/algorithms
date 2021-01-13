package algorithms.randomizeDataStructure

import java.util.Random

// 380. Insert Delete GetRandom O(1)

class RandomizedSet {
    /** Initialize your data structure here.  */
    var map: MutableMap<Int, Int> = mutableMapOf()
    var list: MutableList<Int> = mutableListOf()
    var random = Random()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element.  */
    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) return false
        list.add(`val`)
        map[`val`] = list.size - 1
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element.  */
    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) return false
        val index = map[`val`]!!
        val size = list.size
        val lastValue = list[size - 1]
        list[index] = lastValue
        map[lastValue] = index
        list.removeAt(size - 1)
        map.remove(`val`)
        return true
    }

    /** Get a random element from the set.  */
    fun getRandom(): Int {
        return list[random.nextInt(list.size)]
    }
}

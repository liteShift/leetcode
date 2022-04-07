package easy.graph

import kotlin.math.max


// TODO: Add dictionary to keep track of distances that have been computed so you don't recalculate them
class Solution1162 {
    fun maxDistance(grid: Array<IntArray>): Int {



}

fun main() {
    val testCase = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 1)
    )
    val solution = Solution1162()
    println(solution.maxDistance(testCase))
}
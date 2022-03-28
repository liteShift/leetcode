package easy

class Solution1342 {
    /**
     * reduce [num] to 0 using rules:
     *   if num is even then must divide by 2
     *   if num is odd then must subtract 1
     */
    fun numberOfSteps(num: Int): Int {
        var mutableNum = num
        var steps = 0
        while (mutableNum > 0) {
            if (mutableNum % 2 == 0) mutableNum /= 2 else mutableNum--
            steps++
        }
        return steps
    }
}

fun main() {
    val testN = 14
    val s = Solution1342()
    println(s.numberOfSteps(testN))
}
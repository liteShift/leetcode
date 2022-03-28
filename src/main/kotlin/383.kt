/**
 * using the magazine string can you construct the ransom note? Main constraint is that you can only use each index
 *  in the magazine string once
 */
class Solution383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineCharacterCountMap = magazine.groupingBy { it }.eachCount().toMutableMap()
        for (char in ransomNote) {
            magazineCharacterCountMap[char]?.let {
                if (it <= 0) return false else {
                    magazineCharacterCountMap[char] = it - 1
                }
            } ?: return false
        }
        return true
    }
}

fun main() {
    val magazine = "ab"
    val ransomNote = "aa"
    val solution383 = Solution383()
    println(solution383.canConstruct(ransomNote, magazine))
}
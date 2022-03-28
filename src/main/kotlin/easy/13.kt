package easy

class Solution13 {
    private val romanToIntMap =
        mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    fun romanToInt(s: String): Int {
        var sum = 0
        var i = 0
        while (i < s.length) {
            if (i + 1 <= s.length - 1 && romanToIntMap[s[i]]!! < romanToIntMap[s[i + 1]]!!) {
                sum += romanToIntMap[s[i + 1]]!! - romanToIntMap[s[i]]!!
                i += 2
            } else {
                sum += romanToIntMap[s[i]]!!
                i += 1
            }
        }
        return sum
    }
}

fun main() {
    val tests = mapOf("IV" to 4, "VX" to 5, "IX" to 9, "XC" to 90, "IM" to 999, "MICV" to 1104)
    val solution13 = Solution13()
    tests.forEach {
        val actual = solution13.romanToInt(it.key)
        if (actual != it.value) {
            throw RuntimeException("$actual should be ${it.value}")
        }
    }
}
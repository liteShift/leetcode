class Solution412 {

    private val fizz = "Fizz"
    private val buzz = "Buzz"
    private val fizzBuzz = "$fizz$buzz"

    /** if i % 5 == 0 ->Buzz if i % 3 == 0 Fizz if i%3==0 %% i%5==0 -> FizzBuzz else str(i)*/
    fun fizzBuzz(n: Int): List<String> {
        // n is number of times to repeat the fizz buzz selection logic
        // imagine array is actually 1 indexed
        val answer = mutableListOf<String>()
        repeat(n) {
            val plusOne = it + 1
            when {
                (plusOne % 5 == 0 && plusOne % 3 == 0) -> answer.add(fizzBuzz)
                plusOne % 5 == 0 -> answer.add(buzz)
                plusOne % 3 == 0 -> answer.add(fizz)
                else -> answer.add("$plusOne")
            }
        }
        return answer
    }
}
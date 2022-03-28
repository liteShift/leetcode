package easy

import java.lang.Integer.max

class Solution1672 {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.fold(-1) { maxAccountValue, account -> max(maxAccountValue, account.sum()) }
    }
}

fun main() {
    val x = arrayOf(1, 2, 3).toIntArray()
    println(x.sum())
}
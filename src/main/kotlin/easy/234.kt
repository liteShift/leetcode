/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class Solution234 {
    fun isPalindrome(head: ListNode?): Boolean {
        // iterate over the entire linked list to create a "stack"
        if (head == null) {
            return false
        }
        val s = mutableListOf<Int>()
        s.add(head.`val`)
        var next = head.next
        while (next != null) {
            s.add(next.`val`)
            next = next.next
        }

        var i = 0
        while (i < s.size.div(2)) {
            if (s[i] != s[s.size - 1 - i]) return false
            i += 1
        }
        return true
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(1)
    val next = ListNode(2)
    next.next = ListNode(1)
    head.next = next
    val sol = Solution234()
    println(sol.isPalindrome(head))
}
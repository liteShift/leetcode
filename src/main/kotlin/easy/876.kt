package easy

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution876 {
    fun middleNode(head: ListNode?): ListNode? {
        var fastPtr = head
        var slowPtr = head

        while (fastPtr?.next != null) {
            slowPtr = slowPtr?.next
            fastPtr = fastPtr.next?.next
        }

        return slowPtr // will be at middle
    }
}


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        // Move fast n steps ahead
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If removing the head node
        if(fast == null) {
            return head.next;
        }

        // Move both pointers
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node from end
        slow.next = slow.next.next;

        return head;
    }
}

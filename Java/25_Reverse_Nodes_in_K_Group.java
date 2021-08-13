class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null){
            ListNode tail = pre;
            for(int i = 0; i < k; i ++){
                tail = tail.next;
                if(tail == null) return dummy.next;
            }
            ListNode next = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            head = next;
            pre = tail;
        }
        return dummy.next;
    }
    private ListNode[] myReverse(ListNode head, ListNode tail){
        ListNode pre = tail.next;
        ListNode p = head;
        while(pre != tail){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}

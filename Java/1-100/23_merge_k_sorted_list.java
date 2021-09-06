class Solution {
    /*
    链表hard题
    利用优先级队列可以将所有链表的头节点排序，然后每次取出队列的最小值，
    再将后续链表放回继续排序，直到队列中所有链表都取出为止
    **/
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2 ) -> o1.val - o2.val);
        for(ListNode list : lists){
            //注意队列不能放入空值
            if(list != null)queue.add(list);
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!queue.isEmpty()){
            ListNode list = queue.poll();
            cur.next = list;
            //注意要判断是否为空
            if(list.next != null) queue.add(list.next);
            cur = cur.next;
        }
        return dummy.next;
    }
}
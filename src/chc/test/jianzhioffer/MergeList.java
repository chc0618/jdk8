package chc.test.jianzhioffer;

public class MergeList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(list1 != null && list2 != null){
            ListNode tmp = cur.next;
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;

            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
            cur.next = tmp;
        }
        if (list1 != null){
            cur.next = list1;
        }
        if (list2 != null){
            cur.next = list2;
        }
        return res.next;
    }
}

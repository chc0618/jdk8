package chc.test.jianzhioffer;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = res;
            res = cur;
            cur = tmp;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

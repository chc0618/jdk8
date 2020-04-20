package chc.test.jianzhioffer;

import java.util.Stack;

public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {

        ListNode cur1 = pHead1;
        ListNode resListNode = null;
        while(cur1 != null){
            ListNode cur2 = pHead2;
            while (cur2 != null){
                if(cur2 == cur1){
                    resListNode = cur2;
                    return resListNode;
                }
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
        }
        return resListNode;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null ||pHead2==null)return null;
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        while (pHead1!=null)
        {
            stack1.push(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            stack2.push(pHead2);
            pHead2=pHead2.next;
        }

        ListNode common=null;
        while (!stack1.isEmpty() &&!stack2.isEmpty()){
            if(stack1.peek()==stack2.peek()){
                common=stack1.peek();
                stack1.pop();
                stack2.pop();
            }
            else break;

        }
        return common;
    }
}

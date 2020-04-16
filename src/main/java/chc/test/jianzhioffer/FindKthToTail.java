package chc.test.jianzhioffer;

public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode curNode = head;
        ListNode curNode1 = head;
        int i = k;
        while(i != 0){
            if(curNode1.next == null){
                return null;
            }
            curNode1 = curNode1.next;
            i--;
        }

        while(curNode1.next != null){
            curNode1 = curNode1.next;
            curNode = curNode.next;
        }
        return curNode;

    }
    private ListNode ans ; // 最终返回的结果
    private int sum; // 用来记录当前的节点是倒数第几个节点
    private void dfs(ListNode node , int k){
        if(node.next != null){
            dfs(node.next, k);
        }
        sum++;
        if(sum == k){
            ans = node;
        }
    }
    public ListNode FindKthToTail2(ListNode head,int k) {
        ans = null;
        sum = 0;

        if(head == null){ //说明联表为null, 没必要递归
            return null;
        }
        dfs(head, k);
        return ans;
    }
    public static void main(String[] args) {


    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


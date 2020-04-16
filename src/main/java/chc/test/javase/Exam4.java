package chc.test.javase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Exam4 {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1,2,3,4,5};
        MyData m = new MyData();
        change(i, str, num, arr, m);

        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr + " + arr);
        StringBuffer stringBuffer = new StringBuffer("we arie");
        System.out.println(stringBuffer.length());
        StringBuffer newString = new StringBuffer();
        for(int index = 0; index < stringBuffer.length(); index++){
            System.out.println(index);
            if(stringBuffer.charAt(index) == ' '){
                newString.append("%20");
            } else {
                newString.append(stringBuffer.charAt(index));
            }
        }
        System.out.println(stringBuffer.toString());
        System.out.println(newString.toString());

    }
    public class ListNode {
     int val;
     ListNode next = null;
     ListNode(int val) {
        this.val = val;
     }
    }
    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while(listNode != null){
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }
    public ArrayList<Integer> printListFromTailToHeadNew(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ListNode cur = listNode;
        Stack<Integer> stack = new Stack<Integer>();
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    private static void change(int j, String s, Integer n, int[] a, MyData myData) {
        j += 1;
        s += "wold";
        n += 1;
        a[0] += 1;
        myData.a += 1;
    }


}

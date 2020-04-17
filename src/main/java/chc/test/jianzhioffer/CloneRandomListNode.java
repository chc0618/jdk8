package chc.test.jianzhioffer;

import com.sun.tools.javac.tree.JCTree;

import java.util.HashMap;
import java.util.Map;

public class CloneRandomListNode {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 方法一
     * 1.通过 map存储 复制节点与原节点的关系
     * 2.生成复制节点的next和Random节点关系
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null){
            RandomListNode node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.getOrDefault(pHead, null);
    }

    public RandomListNode Clone2(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        // 第一个过程 -> 创建新节点插入到原链表中
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode tmp = cur.next;
            RandomListNode node = new RandomListNode(cur.label);
            cur.next = node;
            node.next = tmp;
            cur = tmp;
        }
        cur = pHead;
        // 第二个过程 -> 创建random指针
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = pHead;
        // 第三个过程 -> 链表的分割
        RandomListNode cloneHead = pHead.next;
        while (cur != null) {
            RandomListNode node = cur.next;
            cur.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            cur = cur.next;
        }
        return cloneHead;


    }


}

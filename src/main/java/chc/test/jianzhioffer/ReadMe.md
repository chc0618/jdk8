~~~
    方法一
     1.通过 map存储 复制节点与原节点的关系
     2.生成复制节点的next和Random节点关系
~~~

~~~
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
~~~


~~~
方法二

~~~

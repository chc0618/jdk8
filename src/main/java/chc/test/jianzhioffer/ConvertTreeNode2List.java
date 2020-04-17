package chc.test.jianzhioffer;

public class ConvertTreeNode2List {

    private TreeNode ans;
    private TreeNode removeNode;

    /**
     *
     * @param node
     * @param flag  代表第n层节点到达第n+1层节点的方向，
     *              0->第n+1层节点是第n层节点的左孩子
     *              1->第n+1层节点是第n层节点的右孩子
     */
    private void dfs(TreeNode node, int flag){
        if(node.left != null){
            dfs(node.left ,  0);
        }
        if (ans == null) {
            ans = node;
            removeNode = node;
        } else {
            if( flag == 0){
                removeNode.right = node; // 从尾部节点引出一条指向当前节点的边
                node.left = removeNode;
            }else {
                removeNode.right = node;
                node.left = removeNode;  // 从当前节点引出一条到到尾部节点的边

            }
            removeNode = node;
        }
        if(node.right != null){
            dfs(node.right, 1);
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return  null;
        }
        ans = null;
        removeNode = null;
        dfs(pRootOfTree, 0);
        return ans;
    }

    /**
     * 双向链表中 left 标识从左到右  从小到大
     * 双向联表 right 标识从右到左 从小到大
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}

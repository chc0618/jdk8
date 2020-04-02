package chc.test.jianzhioffer;

public class Mirror {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {
        dfs(root);
    }

    private void  dfs(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left != null){
            dfs(node.left);
        }
        if(node.right != null){
            dfs(node.right);
        }
        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;
    }
}

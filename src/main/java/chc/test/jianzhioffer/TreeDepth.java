package chc.test.jianzhioffer;

public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
    public int TreeDepth1(TreeNode root) {
        int resDepth = 0;
        resDepth = treeDepth(root);
        return resDepth;
    }
    int treeDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(node.left != null){
            left = treeDepth(node.left);
        }
        if(node.right != null){
            right = treeDepth(node.right);
        }
        return Math.max(left, right) + 1;
    }
}

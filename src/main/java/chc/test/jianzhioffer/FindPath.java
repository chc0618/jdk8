package chc.test.jianzhioffer;

import java.util.ArrayList;

public class FindPath {

    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, target, 0, list);
        change();
        return res;
    }

    private void change() {
        for(int i = 0; i < res.size(); i++){
            int index = i;
            for(int j = i + 1; j < res.size(); j++){
                if(res.get(index).size() > res.get(j).size()){
                    index = j;
                }
            }
            if(i != index){
                ArrayList<Integer> tmp = res.get(i);
                res.set(i, res.get(index));
                res.set(index, tmp);
            }
        }
    }

    /**
     *
     * @param node 二叉树的节点
     * @param target 目标和
     * @param sum 当前和
     * @param list
     */
    private void solve(TreeNode node, int target, int sum, ArrayList<Integer> list) {
        if(node != null){
            list.add(node.val);
            sum = sum + node.val;
            if(node.left == null && node.right == null){
                if(sum == target){
                    ArrayList resTmp = new ArrayList(list);
                    res.add(resTmp);
                }
            }else {
                solve(node.left, target, sum, list);
                solve(node.right, target, sum, list);
            }
            list.remove(list.size() - 1);
            sum -= node.val;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}

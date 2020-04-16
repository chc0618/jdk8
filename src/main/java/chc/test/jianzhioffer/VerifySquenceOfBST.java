package chc.test.jianzhioffer;

import java.util.ArrayList;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        // 后续变量  根在最后， 先遍历左节点，然后遍历右节点
        if(sequence.length == 0){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < sequence.length; i++){
            list.add(sequence[i]);
        }
        return solve(list);
    }

    private boolean solve(ArrayList<Integer> list){
        // 递归终止条件
        if(list.size() == 0
                || list.size() == 1){
            return true;
        }
        // 用于保存小于endNumber数字序列
        ArrayList<Integer> minList = new ArrayList<>();
        // 保存大于endNumber数字序列
        ArrayList<Integer> maxList = new ArrayList<>();
        int minIndex = -1;
        int maxIndex = -1;
        int endNumber = list.get(list.size() - 1);
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > endNumber){
                if(maxIndex == -1)maxIndex = i;
                maxList.add(list.get(i));
            } else if (list.get(i) < endNumber){
                if(minIndex == -1) minIndex = i;
                minList.add(list.get(i));
            }
        }
        if(minIndex != -1 && maxIndex != -1){
            if(minIndex > maxIndex){
                return false;  // 本质上是使右子树在左子树之前，
            }
            for(int i = maxIndex; i < list.size(); i++){
                if(list.get(i) < endNumber){
                    return false; // 说明在大于endNumber的序列初始位置到末尾，不连续，中间有小于endNumberde 数字分割开来
                }
            }
        }
        return solve(minList) && solve(maxList);
    }



}

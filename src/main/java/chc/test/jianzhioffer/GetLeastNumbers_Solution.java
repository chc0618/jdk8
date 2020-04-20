package chc.test.jianzhioffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


public class GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> resList = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i : input){
            res.add(i);
        }
        Collections.sort(res);
        if(input.length < k){
            return resList;
        }
        for(int i = 0; i < k; i++){
            resList.add(res.get(i));
        }
        return resList;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> resList = new ArrayList<>();
        if(input.length < k){
            return resList;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < input.length; i++){
            if(treeSet.size() < k){
                treeSet.add(input[i]);
            } else {
                if (input[i] < treeSet.last()) {
                    treeSet.pollLast();
                    treeSet.add(input[i]);
                }
            }
        }
        for(int i : treeSet){
            resList.add(i);
        }
        return resList;
    }

    // 通过堆来实现
    public ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> resList = new ArrayList<>();
       if( k > input.length || k==0){
            return resList;
       }
       int[] a = new int[k];
       System.arraycopy(input,0, a,0, k);  // 初始化堆中的数组
        for (int i = k / 2 - 1; i >= 0; i--) {
            initiate(i, a, k);  // i 是 要去维护的节点下标
        }
        for(int i = k; i < input.length; i++){
            if(input[i] < a[0]){
                a[0] = input[i];
                initiate(0, a , k);
            }
        }
        for(int i = a.length - 1; i > 0; i--){
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            initiate(0, a, i);
        }
        for(int x : a){
            resList.add(x);
        }
        return resList;
    }

    /**
     *
     * @param index 当前堆的下标
     * @param a  堆
     * @param length 堆节点的个数
     */
    private void initiate(int index, int[] a, int length) {
        int tmp = a[index]; // 先去保存当前位置的值
        for(int k = 2 * index + 1; k < length; k = k * 2 + 1){
            if((k + 1) < length && a[k] < a[k + 1]){
                k++; //取出当前位置的左右孩子中接地那值的最大节点
            }
            if(a[k] > tmp){
                a[index] = a[k];
                index = k; // 更新index的值，     index代表tmp 最终在堆中的位置，
            }else break; // 由于从上到下维护， 下面无需更新
        }
        a[index] = tmp;
    }

    @Test
    public void test(){
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        int k = 10;
        ArrayList<Integer> arrayList = new GetLeastNumbers_Solution().GetLeastNumbers_Solution(input, k);

        System.out.println(arrayList);
    }
    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        int k = 10;
        ArrayList<Integer> arrayList = new GetLeastNumbers_Solution().GetLeastNumbers_Solution(input, k);

        System.out.println(arrayList);
    }


}

package chc.test.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();

        int resVal = 0;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            if(sum < map.get(array[i])){
                sum = map.get(array[i]);
                resVal = array[i];
            }
        }

        if(sum > array.length/2){
            return resVal;
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {

        if(array.length == 0){
            return 0;
        }
        int target = array[0];  // 用来保存最终出现次数最多的数字
        int sum = 0;  // 用来保存数组从第i个位置， target出现的次数， 不是target出现的次数
        for(int x : array){
            if (x == target) {
                sum++;
            } else {
                sum--;
            }
            if(sum == 0){
                target = x;
                sum = 1;
            }
        }
        if(check(target, array)){
            return target;
        }
        return 0;
    }

    private boolean check(int target, int[] array) {
        int sum = 0;
        for(int x : array){
            if(target == x){
                sum++;
            }
        }
        if(sum > array.length/2){
            return true;
        }
        return false;
    }
}

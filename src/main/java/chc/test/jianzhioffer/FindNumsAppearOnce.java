package chc.test.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> numTimeMap = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(numTimeMap.containsKey(array[i])){
                numTimeMap.put(array[i], 1 + numTimeMap.get(array[i]));
            } else {
              numTimeMap.put(array[i], 1);
            }
        }
        for(int arr : numTimeMap.keySet()){
            if(numTimeMap.get(arr) == 1){
                if(num1[0] == 0){
                    num1[0] = arr;
                }else{
                    num2[0] = arr;
                }
            }
        }
    }
    public void FindNumsAppearOnce1(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
}

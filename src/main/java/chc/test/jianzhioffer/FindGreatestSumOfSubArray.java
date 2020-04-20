package chc.test.jianzhioffer;

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] sum = new int[array.length];
        sum[0] = array[0];
        for(int i = 1; i < array.length; i++){
            sum[i] = sum[i - 1] + array[i];
        }
        int max = sum[0];
        // i是终点 j 是起点
        for (int i = 0; i< array.length; i++) {
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    max = Math.max(max, sum[i]);
                }else max = Math.max(max , sum[i] - sum[j - 1]);
            }
        }

        return max;
    }
    public int FindGreatestSumOfSubArray2(int[] array) {
        int sum = 0;
        int max = array[0];
        // i是终点 j 是起点
        for (int i = 0; i< array.length; i++) {
            sum += array[i];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}

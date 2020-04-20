package chc.test.jianzhioffer;

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0)return 0;
        int[] ugly = new int[index + 1];
        ugly[1] = 1;
        int i2, i3, i5;
        i2 = i3 = i5 = 1;
        for(int i = 2; i <= index; i++){
            ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if(ugly[i] == ugly[i2] * 2)i2++;
            if(ugly[i] == ugly[i3] * 3)i3++;
            if(ugly[i] == ugly[i5] * 5)i5++;
        }
        return ugly[index];
    }
}

package chc.test.jianzhioffer;

public class NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for(int i =0; i <= n; i++){
            int x = i;
            while (x != 0){
                if(x % 10 == 1){
                    sum++;
                }
                x = x/10;
            }
        }
        return sum;
    }
    public int NumberOf1Between1AndN_Solution2(int n) {
       if(n == 0 || n == 1)return n;
       String str = "" + n;
       int len = str.length();
       if(len == 1){
           return 1;
       }
       int res = (int) Math.pow(10, len - 1);
       int firstNum = n / res;
       int firstBit = firstNum == 1 ? (n % res) + 1: res;
       int otherBit = (len - 1) * firstNum * res /10 ;  // (len - 1) 意思是剩余位的个数，
       return firstBit + otherBit + NumberOf1Between1AndN_Solution(n % res);
    }
}

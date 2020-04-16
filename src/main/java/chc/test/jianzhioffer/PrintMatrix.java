package chc.test.jianzhioffer;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int flag = 1; // 1 - right , 2- down, 3-left, 4-up
        int x = 0;
        int y = 0;
        boolean[][] vis = new boolean[matrix.length][matrix[0].length]; // 用来标记已经走过的点
        while(ans.size() < matrix.length * matrix[0].length){
            if(x < 0 || x >= matrix.length || y >= matrix[0].length || y < 0 || vis[x][y]){ //vis[x][y] -> 已经遍历过的位置也当做越界处理
                if(flag == 1){
                    flag = 2;
                    x++;
                    y--;
                }else if(flag == 2){
                    flag = 3;
                    x--;
                    y--;
                }else if(flag == 3){
                    flag = 4;
                    y++; // 消除越界影响
                    x--; // 向上走
                }else {
                    flag = 1;
                    y++;
                    x++;
                }


            } else {
                ans.add(matrix[x][y]);
                vis[x][y] = true; // 标记已经遍历的位置
                //根据flag的值更新
                if(flag == 1){
                    y++;
                }else if(flag == 2){
                    x++;
                }else if(flag == 3){
                    y--;
                }else {
                    x--;
                }
            }
        }
        return ans;
    }
}

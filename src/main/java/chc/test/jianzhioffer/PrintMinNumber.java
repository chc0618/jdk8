package chc.test.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> resList = new ArrayList<>();
        for(int n : numbers){
            resList.add(n);
        }
        Collections.sort(resList, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = String.valueOf(o1);
                String b = String.valueOf(o2);
                return (a + b).compareTo(b + a);
            }
        });
        StringBuilder resStr = new StringBuilder();
        resList.forEach(nu -> {
            resStr.append(nu);
        });
        return resStr.toString();
    }
}

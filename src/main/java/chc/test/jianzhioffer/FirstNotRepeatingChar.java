package chc.test.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder(str);
        for(int i =0; i< stringBuilder.length(); i ++){
            Character charc = stringBuilder.charAt(i);
            if(map.containsKey(charc))map.put(charc, map.get(charc) + 1);
            else map.put(charc, 1);
        }
        int resIdex = -1;
        for(int i = 0; i < stringBuilder.length(); i++){
            if(map.get(stringBuilder.charAt(i)) == 1){
                resIdex = i;
                break;
            }
        }
        return resIdex;
    }
}

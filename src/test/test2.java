package test;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        String str = "kkddpppp00j09933";
        char [] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : list) {
            System.out.println(entry);
        }
    }
}

package test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任意字符串");
        String str = scanner.next();
        //转换得到字符数组表示
        char[] chs = str.toCharArray();
        //创建Map集合保存字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        //遍历字符数组，判断字符是否出现在map中，若出现，则次数+1，
        //否则将字符存入map，并将次数设为1
        for (char c : chs) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // map.forEach((k,v)-> System.out.println(k+"-"+v));
        //对map中的键值对数据根据value（次数）降序排列
        //将map中的所有k-v数据存入list，然后对list排序即可
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        //遍历list
        for (Map.Entry<Character, Integer> entry : list) {
            System.out.println(entry);
        }
    }
}

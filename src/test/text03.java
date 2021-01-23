package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 对字符串进行去重
 */
public class text03 {
    public static void main(String[] args) {
        String str = "thankkkk  youuuuu  veryyyy   muchhh！";
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            if (!list.contains(c)){
                //表示该元素第一次出现 要存入
                list.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        String best = sb.toString();
        System.out.println(best);
    }
}

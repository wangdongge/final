package test;

import java.util.TreeSet;

/**
 * 对2个数组求并集，差集
 */
public class Demo {
    public static void main(String[] args) {
        int[] ary1 = {1,2,3,4,3,4,5};
        int[] ary2 = {3,4,5,6,6,3,9,4,7,8,9};
        //1. 将以上的数组转换为TreeSet集合，去重，且排序了
        TreeSet<Object> set1 = new TreeSet<>();
        TreeSet<Object> set2 = new TreeSet<>();
        for (Object obj : ary1){
            set1.add(obj);
        }
        for (Object obj : ary2){
            set2.add(obj);
        }
        //输出set1，set2，查看集合中的元素是否去重且排序
        for (Object obj:set1){
            System.out.print(obj+" ");
        }
        System.out.println();
        for (Object obj : set2){
            System.out.print(obj+" ");
        }

        //2. 对2个set集合调用addAll方法求并集即可
        sum(set1,set2);
        minus(set1,set2);
    }

    //求差集
    public static void minus(TreeSet<Object> set1,TreeSet<Object> set2){
        //1. 选择长度较短的集合用于遍历-min
        TreeSet<Object> min = set1.size()<set2.size()?set1:set2;
        //2. 根据上述的操作，将另一集合作为保存差集的集合 -max
        TreeSet<Object> max = min == set1 ? set2 : set1;
        //3. 对min集合遍历，若遍历到的元素被max包含，则从max中删除；若不被包含，则添加入max集合
        for (Object obj : min){
            if (max.contains(obj)){
                //obj为交集元素，删除
                max.remove(obj);
            }else {
                //obj为min集合中特有的，为差集元素，添加入max
                max.add(obj);
            }
        }
        //遍历max，即遍历所有的差集元素
        for (Object obj : max){
            System.out.print(obj+" ");
        }
    }

    //求并集
    public static void sum(TreeSet<Object> set1,TreeSet<Object> set2){
        set1.addAll(set2);
        System.out.println("并集为：");
        for (Object obj : set1){
            System.out.print(obj+" ");
        }
    }
}

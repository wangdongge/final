package test;

public class HasStatic {
//    public static void main(String[] args) {
//        String desc = "hello ： helloworldhello  eclipse hello idea hello spring";
//        String subStr = "hello";
//        int count = HasStaticDemo(desc,subStr);
//        System.out.println("子串："+subStr+"出现的次数"+count);
//    }
//    public static int HasStaticDemo(String desc,String subStr){
//        int count = 0;
//        int index = 0;//指针位置 从下标零开始搜索
//        while ((index = desc.indexOf(subStr,index))!=-1){
//            count++;
//            index+=subStr.length();
//        }
//        return count;
//    }

    private int x = 100;
    public static void main(String[] args) {
        HasStatic has1 = new HasStatic();
        has1.x++;
        HasStatic has2 = new HasStatic();
        has2.x += has1.x;
        has1 = new HasStatic();
        has1.x--;
        System.out.println("x="+has1.x);
        System.out.println("x="+has2.x);
    }



//    private static int x = 100;
//    public static void main(String[] args) {
//        HasStatic has1 = new HasStatic();
//        has1.x++;
//        HasStatic has2 = new HasStatic();
//        has2.x += has1.x;
//        has1 = new HasStatic();
//        has1.x--;
//        HasStatic.x--;
//        System.out.println("x="+has1.x);
//    }
}

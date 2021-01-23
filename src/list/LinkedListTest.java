package list;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Sally");
        list.add("Keely");
        list.add("建国");
        list.add("小白");
        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.get(2));
//        System.out.println(list.remove(2));
        list.add(2,"花花");
        System.out.println(list);

    }
}

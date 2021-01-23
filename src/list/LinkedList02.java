package list;

public class LinkedList02 <E> {
    private Node02 head;
    class Node02 {
        E data;
        Node02 next;
        Node02 prev;
        Node02 (E e){
            data = e;
        }
    }

    public boolean add(E e){
        Node02 node02 = new Node02(e);
        if (head == null){
            head = node02;
            head.next = head;
            head.prev = head;
            return true;
        }
        Node02 lsat = node02;
        lsat.next = head;
        node02.next = head;
        head.prev = node02;
        node02.prev = lsat;
        return true;

    }
}

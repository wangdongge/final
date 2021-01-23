package list;

/**
 * 双向循环链表类
 *
 * @param <E>
 */

public class LinkedList <E>{
    //head用于存放头节点的引用
    private Node head;
    //用于存放链表的长度
    private int size = 0;
    /**
     * Node描述里链表中的某个节点
     * 其中，data用于存放数据（元素）
     * next和prev分别用于存放其后继节点
     * 和前驱节点的引用
     *
     */
    class Node{
        E data;
        Node next;
        Node prev;
        Node (E e){
            data = e;
        }
    }

    /**
     * 将元素追加到链表的末尾
     * @param e 要添加的元素
     * @return  添加成功 返回true
     */
    //在双向循环链表后添加节点
    public boolean add(E e){
        //将元素封装成节点
        Node node = new Node(e);
        //如果链表为空 则节点（node）成为头节点
        // 判断链表头节点是否为空
        if (head == null){
            head = node;
            head.next = head;
            head.prev = head;
            //修改链表的长度
            size++;
            return true;
        }
        //找到最后一个节点  尾节点
        Node last = head.prev;
        //将节点（node）添加到尾节点（last）后面
        last.next = node;
        node.next = head;
        head.prev = node;
        node.prev = last;
        //修改链表的长度
        size++;
        return true;
    }

    @Override
    public String toString() {
        if (head == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        //将头节点中存放的数据添加到StringBuilder里面
        sb.append(head.data);
        //找到头节点的下一个节点
        Node node = head.next;
        //当前节点（node）不等于头节点（head）时 可以继续访问
        while (node != head){
            //将当前节点中存放的数据添加到sb
            sb.append(","+node.data);
            //找到当前节点的下一个节点
            node = node.next;
        }
        return sb.append("]").toString();
    }

    public int size(){
        return size;
    }

    /**
     * 返回指定下标处的元素
     * @param index 下标
     * @return
     */
    public E get(int index){
        if (index < 0 || index >=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node node = getNode(index);
        //返回该节点中存放的数据（元素）
        return node.data;
    }

    private Node getNode(int index) {
        Node node = head;
        //如果下标小于或等于链表长度的一半 则通过next属性来顺序查找
        if (index <= size >> 1){
            for (int i = 0; i < index; i++) {
                 node = node.next;
            }
        }else {
            //如果下标大于链表长度的一半 则通过prev属性来顺序查找
            for (int i = size; i < index; i--) {
                 node = node.prev;
            }
        }
        return node;
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 ||index >= size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        //如果链表的长度是1 该节点肯定是头节点，在该节点删除之后
        //需要将head设置为null
        if (size == 1){
            E e = head.data;
            head = null;
            size--;
            return e;
        }
        //找到要删除的节点
        Node node = getNode(index);
        //找到该节点的前驱节点和后继节点
        Node perv = node.prev;
        Node next = node.next;
        //在前驱节点和后继节点之间建立引用关系
        next.prev = perv;
        perv.next = next;
        //如果删除的是头节点 则其下一个节点成为头节点
        if (index == 0){
            head = next;
        }
        size--;
        return node.data;
    }

    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        //如果下标等于size 则使用追加元素方法
        if (index == size){
            add(e);
            return;
        }
        //元素封装节点
        Node node = new Node(e);
        //找到下标等于index的节点 （该节点会成为新节点的之一个节点）
        Node next = getNode(index);
        //找到新节点的前驱节点
        Node perv = next.prev;
        //将新节点添加到next和perv之间
        perv.next = node;
        node.next = next;
        next.prev = node;
        node.prev = perv;
        //如果index等于0则新添加的节点成为头节点
        if (index == 0){
            head = node;
        }
        size++;

    }
}

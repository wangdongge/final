package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(88);
        tree.add(66);
        tree.add(100);
        tree.add(55);
        System.out.println(tree);
    }
}

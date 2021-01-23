package tree;

public class BinaryTree<E extends Comparable<E>>{
    private Node root;

    /**
     *
     */
    class Node{
        E data;
        Node left;
        Node right;

        public Node(E e) {
            data = e;
        }

        /**
         * 将元素添加到某个节点下面
         * @param e  要添加的元素
         * @return  添加成功返回true
         * 注：
         *     排序二叉树不允许出现重复元素
         */
        public boolean append(E e) {
            if (data.compareTo(e) == 0){
                return false;
            }
            //要添加的元素（e） 比当前节点中存放的元素要小 则将其添加到当前节点左边
            if (data.compareTo(e) > 0){
                //情形1：左子树为null 则新节点成为其左子树
                if (left == null){
                    left = new Node(e);
                    return true;
                }else {
                    //情形2：左子树不为空 则将该元素添加到其左子树下
                    return left.append(e);
                }
            }else {
                //要添加的元素（e） 比当前节点中存放的元素要大 则将其添加到当前节点右边
                if (right == null){
                    right = new Node(e);
                    return true;
                }else {
                    return right.append(e);
                }
            }
        }

        /**
         * 中序遍历方法
         * @param sb
         */
        public void inOrder(StringBuilder sb) {
            //如果左子树不为空 则对左子树进行中序遍历
            if (left != null){
                left.inOrder(sb);
            }
            //访问根节点
            sb.append(data+",");
            //如果右子树不为空 则对右子树进行遍历
            if (right != null){
                right.inOrder(sb);
            }

        }
    }

    /**
     * 将元素添加到二叉树
     * @param e  要添加的元素
     * @return  添加成功 返回true
     */
    public boolean add(E e){
        //如果二叉树为空 则新节点成为根节点
        if(root == null){
            root = new Node(e);
            return true;
        }
        //如果二叉树不为空 则将该元素添加到根节点下面
        return root.append(e);
    }

    @Override
    public String toString() {
        if (root == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        //inOrder方法会对二叉树进行中序遍历，在遍历过程中 会将访问到的节点中的元素添加到sb对象中
        root.inOrder(sb);
        //去掉最末尾的逗号
        sb.delete(sb.lastIndexOf(","), sb.length());
        return sb.append("]").toString();
    }
}

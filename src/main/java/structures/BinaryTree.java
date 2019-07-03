//package structures;
//
//public class BinaryTree<T extends Comparable> {
//    public class Node<T extends Comparable>{
//        T value;
//        Node<T> left;
//        Node<T> right;
//
//        Node(T value,Node<T> left,Node<T>right){
//            this.value=value;
//            this.left=left;
//            this.right=right;
//        }
//    }
//
//    private Node<T> root;
//
//    public Node insert(T key){
//         root=insert(key,root);
//         return root;
//    }
//
//    public Node remove(T key){
//        root=remove(key,root);
//        return root;
//    }
//
//    public void midOrder(){
//        midOrder(root);
//    }
//
//    private void midOrder(Node root){
//        if (root!=null){
//            midOrder(root.left);
//            System.out.println(root.value);
//            midOrder(root.right);
//        }
//    }
//
//    public boolean contain(T key){
//        return contain(key,root)!=null;
//    }
//
//    private Node contain(T key, Node<T> root) {
//        if (root==null){
//            return null;
//        }
//        int compareTo=key.compareTo(root.value);
//        if (compareTo>0){
//            return contain(key,root.right);
//        } else if (compareTo<0){
//            return contain(key,root.left);
//        }else {
//            return root;
//        }
//    }
//
//    private Node<T> insert(T key, Node<T> root){
//        if (root==null){
//            return new Node<>(key,null,null);
//        }
//        int compareRs =key.compareTo(root.value);
//        if (compareRs>0){
//            root.right=insert(key,root.right);
//        }else if(compareRs<0){
//            root.left=insert(key,root.left);
//        }else
//            ;
//        return root;
//    }
//
//    private Node<T> remove(T key, Node<T> root){
//        if (root==null){
//            return root;
//        }
//        int compareRs =key.compareTo(root.value);
//        if (compareRs>0){
//            root.right=remove(key,root.right);
//        }else if (compareRs<0){
//            root.left=remove(key,root.left);
//        }else if (root.left!=null&&root.right!=null){
//            root.value=findMin(root.right).value;
//            root.right=remove(root.value,root.right);
//        }else {
//            root=(root.left==null)?root.right:root.left;
//        }
//        return root;
//    }
//
//    private Node<T> findMin(Node root){
//        if (root==null){
//            return null;
//        }else if (root.left==null){
//            return root;
//        }else {
//            return findMin(root.left);
//        }
//    }
//
//    public Node<T> findMin(){
//      return findMin(root);
//    }
//
//}

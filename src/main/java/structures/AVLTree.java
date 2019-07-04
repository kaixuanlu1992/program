package structures;

public class AVLTree<T extends Comparable> {
    private AvlNode root;

    private static final int ALLOWED_IMBLANCE = 1;

    public class AvlNode<T> {
        T value;
        int height;
        AvlNode<T> left;
        AvlNode<T> right;

        AvlNode(T value) {
            this(value, null, null);
        }

        AvlNode(T value, AvlNode left, AvlNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }

    private int height(AvlNode root) {
        return root == null ? -1 : root.height;
    }

    private AvlNode<T> insert(T value, AvlNode root) {
        if (root == null) {
            return new AvlNode<>(value);
        }
        int compare = value.compareTo(root.value);
        if (compare > 0) {
            root.right = insert(value, root.right);
        } else if (compare < 0) {
            root.left = insert(value, root.left);
        }
        return balance(root);

    }

    private AvlNode<T> balance(AvlNode root) {
        if (root == null) {
            return root;
        }
        if (height(root.left) - height(root.right) > ALLOWED_IMBLANCE) {
            if (height(root.left.left) > height(root.left.right)) {
                root = rotateWithLeftChild(root);
            } else {
                root = doubleWithLeftChild(root);
            }
        } else if (height(root.right) - height(root.left) > ALLOWED_IMBLANCE) {
            if (height(root.right.right) > height(root.right.left)) {
                root = rotateWithRight(root);
            } else {
                root = doubleWithRight(root);
            }
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    private AvlNode doubleWithRight(AvlNode root) {
        root.left=rotateWithLeftChild(root.right);
        return rotateWithRight(root);
    }

    private AvlNode rotateWithRight(AvlNode root) {
        AvlNode temp = root.right;
        root.right = temp.left;
        temp.left = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        temp.height = Math.max(height(temp.right), root.height) + 1;
        return temp;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode root) {
        root.left=rotateWithRight(root.left);
        return rotateWithLeftChild(root);

    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> root) {
        AvlNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        temp.height = Math.max(height(temp.left), root.height) + 1;
        return temp;
    }

    private AvlNode<T> remove(T x, AvlNode<T> root){
        if (root==null){
            return root;
        }

        int compare=x.compareTo(root.value);
        if (compare<0){
            root.left=remove(x,root.left);
        } else if (compare>0){
            root.left=remove(x,root.right);
        }else if (root.left!=null&&root.right!=null){
            root.value=findMin(root.right).value;
            root.right=remove(root.value,root.right);
        }else {
            root=(root.left==null)?root.right:root.left;
        }
        return balance(root);
    }

    private AvlNode<T> findMin(AvlNode<T> right) {
        if (root==null){
            return null;
        }else if (root.left==null){
            return root;
        }else {
            return findMin(root.left);
        }
    }

}

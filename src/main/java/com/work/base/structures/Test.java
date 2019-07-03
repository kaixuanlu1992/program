package com.work.base.structures;

public class Test {
    public static void main(String[] args){
        BinaryTree<Integer> tree=new BinaryTree<>();
        tree.insert(23);
        tree.insert(24);
        tree.insert(44);
        tree.insert(56);
        tree.insert(76);
        tree.insert(12);
        tree.insert(14);
        tree.insert(98);
        tree.insert(3);
        tree.insert(66);
        tree.insert(23);
        tree.midOrder();
        System.out.println(tree.contain(15));
        System.out.println(tree.contain(14));
        tree.levelScan();

    }
}

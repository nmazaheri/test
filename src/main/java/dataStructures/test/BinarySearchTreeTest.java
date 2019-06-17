package dataStructures.test;

import dataStructures.BinarySearchTree;

/**
 * Created by nav on 5/18/15.
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addNode(30);
        binarySearchTree.addNode(15);
        binarySearchTree.addNode(35);
        binarySearchTree.addNode(40);
        binarySearchTree.addNode(33);
        binarySearchTree.addNode(34);
        binarySearchTree.addNode(35);
        System.out.println(binarySearchTree.isBalanced());
        binarySearchTree.addNode(5);
        binarySearchTree.addNode(25);

        binarySearchTree.inOrderTraverseTree();
        System.out.println();
        binarySearchTree.preOrderTraverseTree();
        System.out.println();
        binarySearchTree.postOrderTraverseTree();
        System.out.println();
        System.out.println(binarySearchTree.findNode(33));
        System.out.println(binarySearchTree.getMaxHeight(binarySearchTree.getRoot()));
        System.out.println(binarySearchTree.isBalanced());

        binarySearchTree.removeNode(35);
        binarySearchTree.inOrderTraverseTree();
        System.out.println();
        System.out.println();

        BinarySearchTree binarySearchTree2 = new BinarySearchTree(
                new int[] { 5, 10, 15, 17, 20, 25, 30, 35, 40, 42, 45, 48, 50 });
        binarySearchTree.inOrderTraverseTree();
        System.out.println();
        System.out.println(binarySearchTree2.isBalanced());

    }
}
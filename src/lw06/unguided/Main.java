package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String firstLine = read.nextLine();
        String[] nums = firstLine.split(" ");

        Node root = null;

         BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < nums.length; i++) {
            int value = Integer.parseInt(nums[i]);
            bst.insert(value);
        }

        int target = read.nextInt();

        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

        read.close();
    }
}
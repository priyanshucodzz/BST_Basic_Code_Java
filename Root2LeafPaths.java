import java.util.*;

public class Root2LeafPaths {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;

        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val); 
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val); 
        } else {
            root.right = insert(root.right, val); // Insert into the right subtree
        }
        return root;
    }

    public static void printpath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "-> ");
        }
        System.out.println("Null");
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left); 
        System.out.print(root.data + " "); 
        inorder(root.right); 
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printpath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1); // backtracking

    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        inorder(root);
        System.out.println();
        printRoot2Leaf(root, new ArrayList<>());
    }
}

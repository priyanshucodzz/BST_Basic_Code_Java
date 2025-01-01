public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
         
        }
    }

    // Insert method
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val); // Create a new node when root is null
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val); // Insert into the left subtree
        } else {
            root.right = insert(root.right, val); // Insert into the right subtree
        }
        return root;
    }

    // In-order traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left); // Traverse left subtree
        System.out.print(root.data + " "); // Print current node
        inorder(root.right); // Traverse right subtree
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7}; // Input values
        Node root = null; // Initialize root as null

        for (int val : values) {
            root = insert(root, val); // Insert each value into the BST
        }

        inorder(root); // Perform in-order traversal
        System.out.println(); // Print a newline after traversal
    }
}

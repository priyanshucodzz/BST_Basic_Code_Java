public class DeleteANode {
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
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node delete(Node root, int key) {
        if (root.data < key) {
            root.right = delete(root.right, key);
        } else if (root.data > key) {
            root.left = delete(root.left, key);
        } else {// voila case

            // case1
            if (root.left == null && root.right == null) {
                return null;
            }
            // case2 - single child

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case3 - 2 child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        inorder(root);
        System.out.println();
        root = delete(root, 1);
        System.out.println();
        inorder(root);
    }

}

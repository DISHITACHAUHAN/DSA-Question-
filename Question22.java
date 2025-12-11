import java.util.Scanner;

// Node class
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Binary Tree class
class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    // Pre-order traversal: Root -> Left -> Right
    void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-order traversal: Left -> Root -> Right
    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Post-order traversal: Left -> Right -> Root
    void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}

// Main class
public class Question22{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        int[] nodes = new int[n];

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) nodes[i] = sc.nextInt();

        // Simple insertion (for demo, create a binary tree like a complete tree)
        tree.root = buildTree(nodes, 0);

        System.out.print("Pre-order traversal: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.print("In-order traversal: ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postOrder(tree.root);
        System.out.println();

        sc.close();
    }

    // Helper function to create a simple binary tree from array
    static Node buildTree(int[] arr, int index) {
        if (index >= arr.length) return null;
        Node node = new Node(arr[index]);
        node.left = buildTree(arr, 2 * index + 1);
        node.right = buildTree(arr, 2 * index + 2);
        return node;
    }
}

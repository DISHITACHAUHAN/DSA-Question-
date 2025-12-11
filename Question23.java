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

// BST class
class BST {
    Node root;

    BST() {
        root = null;
    }

    // Insert a node
    Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.data) node.left = insert(node.left, key);
        else if (key > node.data) node.right = insert(node.right, key);
        // if key == node.data, duplicates are ignored
        return node;
    }

    // Search a node
    boolean search(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    // Find minimum node in subtree
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Delete a node
    Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.data) node.left = delete(node.left, key);
        else if (key > node.data) node.right = delete(node.right, key);
        else { // Node found
            // Node with only one child or no child
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // Node with two children: get inorder successor
            Node temp = minValueNode(node.right);
            node.data = temp.data;
            node.right = delete(node.right, temp.data);
        }
        return node;
    }

    // In-order traversal (sorted order)
    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
}

// Main class
public class Question23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        int choice, key;

        do {
            System.out.println("\n--- BST MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display (In-order)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    key = sc.nextInt();
                    bst.root = bst.insert(bst.root, key);
                    System.out.println(key + " inserted.");
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    key = sc.nextInt();
                    bst.root = bst.delete(bst.root, key);
                    System.out.println(key + " deleted (if existed).");
                    break;
                case 3:
                    System.out.print("Enter key to search: ");
                    key = sc.nextInt();
                    boolean found = bst.search(bst.root, key);
                    System.out.println(found ? key + " found in BST." : key + " not found.");
                    break;
                case 4:
                    System.out.print("BST in-order: ");
                    bst.inOrder(bst.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

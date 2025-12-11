import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Insert at start
    void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println(data + " inserted at start.");
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println(data + " inserted at end.");
    }

    // Insert at position (1-based)
    void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        if (pos == 1) {
            insertAtStart(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;

        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println(data + " inserted at position " + pos + ".");
    }

    // Delete at start
    void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println(head.data + " deleted from start.");
        head = head.next;
    }

    // Delete at end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            System.out.println(head.data + " deleted from end.");
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        System.out.println(temp.next.data + " deleted from end.");
        temp.next = null;
    }

    // Delete at position (1-based)
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            deleteAtStart();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;

        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds!");
            return;
        }

        System.out.println(temp.next.data + " deleted from position " + pos + ".");
        temp.next = temp.next.next;
    }

    // Search for an element
    void search(int key) {
        Node temp = head;
        int pos = 1;
        boolean found = false;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println(key + " found at position " + pos);
                found = true;
                break;
            }
            temp = temp.next;
            pos++;
        }
        if (!found) System.out.println(key + " not found in the list.");
    }

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Question17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert at start");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at start");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete at position");
            System.out.println("7. Search");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    list.insertAtStart(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter element to insert: ");
                    list.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter element to insert: ");
                    int data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(data, pos);
                    break;
                case 4:
                    list.deleteAtStart();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    list.deleteAtPosition(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter element to search: ");
                    list.search(sc.nextInt());
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);

        sc.close();
    }

}

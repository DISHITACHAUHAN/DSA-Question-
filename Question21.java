import java.util.Scanner;

class CircularQueue {
    int[] arr;
    int front, rear, size, capacity;

    // Constructor
    CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    boolean isFull() {
        return size == capacity;
    }

    // Enqueue / Push
    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot insert " + data);
            return;
        }
        if (isEmpty()) front = 0;
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue / Pop
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        if (size == 0) front = rear = -1; // reset queue
        return data;
    }

    // Display queue elements
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0, idx = front; i < size; i++, idx = (idx + 1) % capacity) {
            System.out.print(arr[idx] + " ");
        }
        System.out.println();
    }
}

// Main class
public class Question21{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue capacity: ");
        int cap = sc.nextInt();
        CircularQueue queue = new CircularQueue(cap);

        int choice;
        do {
            System.out.println("\n--- CIRCULAR QUEUE MENU ---");
            System.out.println("1. Enqueue (Push)");
            System.out.println("2. Dequeue (Pop)");
            System.out.println("3. Display");
            System.out.println("4. Check isEmpty");
            System.out.println("5. Check isFull");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    int data = queue.dequeue();
                    if (data != -1) System.out.println("Dequeued element: " + data);
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Queue is " + (queue.isEmpty() ? "empty." : "not empty."));
                    break;
                case 5:
                    System.out.println("Queue is " + (queue.isFull() ? "full." : "not full."));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}


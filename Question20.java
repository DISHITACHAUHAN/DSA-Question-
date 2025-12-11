import java.util.Scanner;

class Stack {
    int[] arr;
    int top;
    int capacity;

    // Constructor
    Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    // Push element
    void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }
        arr[++top] = x;
        System.out.println(x + " pushed to stack.");
    }

    // Pop element
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    boolean isFull() {
        return top == capacity - 1;
    }

    // Display stack
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Main class
public class Question20{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack capacity: ");
        int size = sc.nextInt();

        Stack stack = new Stack(size);
        int choice;

        do {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Check isEmpty");
            System.out.println("5. Check isFull");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped != -1)
                        System.out.println("Popped element: " + popped);
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Stack is " + (stack.isEmpty() ? "empty." : "not empty."));
                    break;
                case 5:
                    System.out.println("Stack is " + (stack.isFull() ? "full." : "not full."));
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

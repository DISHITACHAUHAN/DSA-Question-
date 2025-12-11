import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[20]; // max size
        int n;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // ---------------- INSERTION ----------------
        System.out.print("Enter position to insert (0 to " + n + "): ");
        int pos = sc.nextInt();

        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();

        // shifting elements to the right
        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = value;
        n++;

        System.out.println("Array after insertion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // ---------------- DELETION ----------------
        System.out.print("\nEnter position to delete (0 to " + (n - 1) + "): ");
        int delPos = sc.nextInt();

        // shifting elements to the left
        for (int i = delPos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;

        System.out.println("Array after deletion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

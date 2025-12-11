import java.util.Scanner;

public class Question11 {

    // Find first occurrence
    static int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                high = mid - 1; // search left half
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Find last occurrence
    static int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; // search right half
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input element to search
        System.out.print("Enter element to find: ");
        int x = sc.nextInt();

        int first = firstOccurrence(arr, x);
        int last = lastOccurrence(arr, x);

        if (first != -1)
            System.out.println("First occurrence: " + first + ", Last occurrence: " + last);
        else
            System.out.println("Element not found");

        sc.close();
    }

}

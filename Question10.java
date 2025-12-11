import java.util.Scanner;

public class Question10 {

    // Binary Search Function
    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;            // found

            if (arr[mid] < target)
                low = mid + 1;         // search right half
            else
                high = mid - 1;        // search left half
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 5, 8, 12, 16, 23, 38};
        System.out.println("Array is: ");
        for(int i=0;i<arr.length;i++){
              System.out.print ( arr[i] + " ");
        }
        System.out.println();
        System.out.println("Enter the target from array");
         int target = sc.nextInt();

        int index = binarySearch(arr, target);
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found");
    }

}

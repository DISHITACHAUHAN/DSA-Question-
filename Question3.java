import java.util.Scanner;

public class Question3 {
   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        System.out.println("Enter elements of first matrix (A):");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix (B):");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Addition
        int[][] sum = new int[r][c];
        System.out.println("\nSum of A and B:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum[i][j] = A[i][j] + B[i][j];
            }
        }
        printMatrix(sum);

        // Multiplication (matrix multiplication)
        // For multiplication, number of columns of A must equal number of rows of B.
        // Here we assume square matrices for simplicity:
        if (r != c) {
            System.out.println("\nMultiplication requires square matrices in this simple version.");
        } else {
            int[][] prod = new int[r][c];
            System.out.println("\nProduct of A and B:");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    prod[i][j] = 0;
                    for (int k = 0; k < c; k++) {
                        prod[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            printMatrix(prod);
        }
    }

    static void printMatrix(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

}

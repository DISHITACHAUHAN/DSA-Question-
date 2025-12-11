public class Question9 {
    public static void main(String[] args) {
        int[][] mat = {
            {3, 8, 9},
            {2, 5, 7},
            {4, 6, 1}
        };

        int target = 7;
        boolean found = false;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == target) {
                    System.out.println("Found at row " + i + ", column " + j);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Element not found!");
        }
    }

}

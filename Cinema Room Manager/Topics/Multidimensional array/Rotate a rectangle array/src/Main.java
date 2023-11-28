import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][] inputArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                inputArray[i][j] = scanner.nextInt();
                System.out.print(inputArray[i][j]);
                if (j < m - 1) {
                    System.out.print(" ");
                }
            }
            if (i < n - 1) {
                System.out.println();
            }
        }


    }
}
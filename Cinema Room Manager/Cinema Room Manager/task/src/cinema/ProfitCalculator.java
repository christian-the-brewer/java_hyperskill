package cinema;

import java.util.Scanner;

public class ProfitCalculator {
    public static void calculate() {
        int rows, seatsInRow, profit = 0, remainder, frontRows, backRows;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsInRow = scanner.nextInt();

        frontRows = rows / 2;
        remainder = rows % 2 == 0? 0: 1;
        backRows = frontRows + remainder;

        if (rows * seatsInRow <= 60) {
            profit = rows * seatsInRow * 10;
        } else {
            profit = (frontRows * seatsInRow * 10) + (backRows * seatsInRow * 8);
        }

        System.out.println("Total income:\n$" + profit);
    }
}

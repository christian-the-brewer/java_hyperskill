package cinema;

public class Cinema {
    final static int numberOfRows = 7;
    final static int numberOfSeatInRow = 8;

    public static void main(String[] args) {
        System.out.println("Cinema:");
        for (int i = 0; i <= numberOfRows; i++) {
            for (int j = 0; j <= numberOfSeatInRow; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print("  ");
                    } else {
                        System.out.print(j + " ");
                    }
                } else {
                    if (j == 0) {
                        System.out.print(i + " ");
                    } else if (j == numberOfSeatInRow){
                        System.out.print("S");
                    } else {
                        System.out.print("S ");
                    }
                }
                if (j == numberOfSeatInRow) {
                    System.out.println();
                }
            }
        }

        ProfitCalculator.calculate();
    }
}
package cinema;

public class Theatre {
    private int rows, seatsPerRow, chosenRow, chosenSeat;
    int frontTicket = 10, backTicket = 8;
    String[][] seatingMatrix;


    public Theatre(int rows, int seats) {
        this.rows = rows;
        this.seatsPerRow = seats;
    }

    public Theatre() {

    }

    public int getTicketPrice() {
        if (rows * seatsPerRow <= 60) {
            return frontTicket;
        } else {
            int rowsInFront = rows / 2;
            if (chosenRow <= rowsInFront) {
                return frontTicket;
            } else {
                return backTicket;
            }
        }
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public void setChosenRow(int row) {
        this.chosenRow = row;
    }

    public void setChosenSeat(int seat) {
        this.chosenSeat = seat;
    }

    public void setSeatingMatrix() {
        seatingMatrix = new String[rows][seatsPerRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (chosenRow == (i - 2) && chosenSeat == (j - 3)) {
                    seatingMatrix[i][j] = "B";
                } else {
                    seatingMatrix[i][j] = "S";
                }

            }
        }
    }
    public void printSeating() {
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seatsPerRow; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print("  ");
                    } else if (j == seatsPerRow) {
                        System.out.println(j);
                    } else {
                        System.out.print(j + " ");
                    }
                } else if (j == 0) {
                        System.out.print(i + " ");
                } else if (j == seatsPerRow) {
                    System.out.println(seatingMatrix[i - 1][j - 1]);
                } else {
                    System.out.print(seatingMatrix[i - 1][j - 1] + " ");
                }
            }
        }

    }
}

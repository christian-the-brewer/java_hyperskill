package cinema;

import java.util.Scanner;

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

    public void createSeatingString() {
        this.seatingMatrix = new String[rows][seatsPerRow];
    }

    public void setSeatingMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (this.seatingMatrix[i][j] == null) {
                    this.seatingMatrix[i][j] = "S";
                } else if (this.seatingMatrix[i][j].equals("S")) {
                    this.seatingMatrix[i][j] = "S";
                } else if (this.seatingMatrix[i][j].equals("B")) {
                    this.seatingMatrix[i][j] = "B";
                }
            }
        }
        if (chosenSeat != 0) {
            this.seatingMatrix[chosenRow - 1][chosenSeat - 1] = "B";
        }
    }

    public void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }

    public void buyTicket(Scanner scanner) {
        System.out.println("Enter a row number:");
        setChosenRow(scanner.nextInt());
        System.out.println("Enter a seat number in that row:");
        setChosenSeat(scanner.nextInt());
        System.out.println("Ticket price: $" + getTicketPrice());
        setSeatingMatrix();
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
                    System.out.println(this.seatingMatrix[i - 1][j - 1]);
                } else {
                    System.out.print(this.seatingMatrix[i - 1][j - 1] + " ");
                }
            }
        }

    }
}

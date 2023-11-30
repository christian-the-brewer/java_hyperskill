package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Theatre {
    private int rows, seatsPerRow, chosenRow, chosenSeat, soldOutIncome;
    int frontTicket = 10, backTicket = 8, ticketsPurchased = 0, currentIncome = 0;
    String[][] seatingMatrix;
    List<String> reservedSeats = new ArrayList<String>();


    public Theatre(int rows, int seats) {
        this.rows = rows;
        this.seatsPerRow = seats;
    }

    public Theatre() {

    }

    public int getCurrentIncome() {
        return this.currentIncome;
    }

    public double getPercentageTicketsSold() {
        double totalSeats = rows * seatsPerRow;
        return  (this.ticketsPurchased / totalSeats) * 100.00;
    }

    public int getSoldOutIncome() {
        if (rows * seatsPerRow > 60) {
            int totalFrontIncome = (rows / 2) * seatsPerRow * frontTicket;
            int totalBackIncome = (rows - (rows / 2)) * seatsPerRow * backTicket;
            return totalFrontIncome + totalBackIncome;
        } else {
            return rows * seatsPerRow * frontTicket;
        }
    }

    public int getTicketPrice() {
        if (rows * seatsPerRow <= 60) {
            return frontTicket;
        } else {
            int rowsInFront = rows / 2;
            if (chosenRow <= rowsInFront) {
                this.currentIncome +=frontTicket;
                return frontTicket;
            } else {
                this.currentIncome += backTicket;
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

    public void setTicketsPurchased() {
        this.ticketsPurchased += 1;
    }

    public int getTicketsPurchased() {
        return this.ticketsPurchased;
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

    public String[][] getSeatingMatrix() {
        return this.seatingMatrix;
    }

    public void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void printStatistics() {
        System.out.println("Number of purchased tickets: " + getTicketsPurchased());
        System.out.printf("Percentage: %.2f%%%n", getPercentageTicketsSold());
        System.out.println("Current income: $" + getCurrentIncome());
        System.out.println("Total income: $" + getSoldOutIncome());
    }

    public void buyTicket(Scanner scanner) {
        while (true) {
            System.out.println("Enter a row number:");
            setChosenRow(scanner.nextInt());
            System.out.println("Enter a seat number in that row:");
            setChosenSeat(scanner.nextInt());
            //check for out of bound selection
            if (this.chosenRow < 1 || this.chosenRow > rows) {
                System.out.println("Wrong input!");
            } else if (this.chosenSeat < 1 || this.chosenSeat > seatsPerRow) {
                System.out.println("Wrong input!");
            } else if (this.seatingMatrix[this.chosenRow - 1][this.chosenSeat - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                break;
            }

//            if (this.chosenRow <= rows && this.chosenSeat <= seatsPerRow && this.chosenRow > 0 && this.chosenSeat > 0) {
//                if () {
//                    System.out.println("That ticket has already been purchased!");
//            }
//
//            } if (this.chosenRow > rows || this.chosenRow < 1 || this.chosenSeat > seatsPerRow || this.chosenSeat < 1 && !this.seatingMatrix[chosenRow][chosenSeat].equals("B")) {
//                System.out.println("Wrong Input");
//            } else
//            {
//                break;
//            }
        }
        System.out.println("Ticket price: $" + getTicketPrice());
        setSeatingMatrix();
        setTicketsPurchased();

    }

    private void addSeatToArray(int row, int seat) {
        this.reservedSeats.add(Integer.toString(row) + Integer.toString(seat));
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

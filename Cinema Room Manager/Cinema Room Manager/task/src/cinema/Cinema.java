package cinema;

import java.util.Scanner;

public class Cinema {



    public static void main(String[] args) {


//        int rows, seatsPerRow, ticketPrice, chosenRow, chosenSeat;
//        int frontRowPrice = 10, backRowPrice = 8;
        Theatre cinema = new Theatre();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        cinema.setRows(scanner.nextInt());
        System.out.println("Enter the number of seats in each row:");
        cinema.setSeatsPerRow(scanner.nextInt());
        cinema.setSeatingMatrix();
        cinema.printSeating();

//        System.out.println("Cinema:");
//        for (int i = 0; i <= rows; i++) {
//            for (int j = 0; j <= seatsPerRow; j++) {
//                if (i == 0 && j == 0) {
//                    System.out.print("  ");
//                } else if (j == 0) {
//                    System.out.print(i + " ");
//                } else if (i == 0 && j == seatsPerRow) {
//                    System.out.println(j);
//                } else if (i == 0) {
//                    System.out.print(j + " ");
//                } else if (j == seatsPerRow) {
//                    System.out.println("S");
//                } else {
//                    System.out.print("S ");
//                }
//            }
//        }

        System.out.println("Enter a row number:");
        cinema.setChosenRow(scanner.nextInt());
        System.out.println("Enter a seat number in that row:");
        cinema.setChosenSeat(scanner.nextInt());


        System.out.println("Ticket price: $" + cinema.getTicketPrice());
        cinema.printSeating();
//        System.out.println("Cinema:");
//
//        for (int i = 0; i <= rows; i++) {
//            for (int j = 0; j <= seatsPerRow; j++) {
//                if (i == 0 && j == 0) {
//                    System.out.print("  ");
//                } else if (j == 0) {
//                    System.out.print(i + " ");
//                } else if (i == 0 && j == seatsPerRow) {
//                    System.out.println(j);
//                } else if (i == 0) {
//                    System.out.print(j + " ");
//                } else if (j == seatsPerRow) {
//                    System.out.println((j == chosenSeat && i == chosenRow) ? "B " : "S");
//                } else {
//                    System.out.print((j == chosenSeat && i == chosenRow) ? "B " : "S ");
//                }
//            }
//        }
    }

    public static void getTicketPrice() {

    }

    public static void printCinema() {

    }

    public static void printCinema(int row, int seat) {

    }
}


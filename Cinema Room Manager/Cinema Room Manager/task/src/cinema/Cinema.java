package cinema;

import java.util.Scanner;

public class Cinema {



    public static void main(String[] args) {
        boolean menuOpen = true;
        int userInput;
        Theatre cinema = new Theatre();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        cinema.setRows(scanner.nextInt());
        System.out.println("Enter the number of seats in each row:");
        cinema.setSeatsPerRow(scanner.nextInt());
        cinema.setSeatingMatrix();

        while (menuOpen) {
            cinema.printMenu();
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    cinema.printSeating();
                    break;
                case 2:
                    cinema.buyTicket(scanner);
                    break;
                case 0:
                    menuOpen = false;
                    break;
                default:
                    break;
            }

        }
    }
}


package battleship;

import java.util.Scanner;

public class GameBoard {

    private String[][] board = new String[11][11];
    private int y1, y2, x1, x2;
    private int[] userCoordinates = new int[4];
    public GameBoard() {
        setInitialGameBoard();
    }

    //setInitial for creating a "blank" game board for a player.
    public void setInitialGameBoard() {
        char tempChar;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    if (j == 0) {
                        this.board[i][j] = " ";
                    } else {
                        this.board[i][j] = String.valueOf(j);
                    }
                } else if (j == 0) {
                    tempChar = (char) (i + 64);
                    this.board[i][j] = String.valueOf(tempChar);
                } else {
                    this.board[i][j] = "~";
                }
            }
        }
    }

    //printBoard for printing the board with \n and space formatting
    public void printBoard() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (j == 10) {
                    System.out.println(this.board[i][j]);
                } else {
                    System.out.print(this.board[i][j] + " ");
                }
            }
        }
    }

    //placeShip will take in two string coordinates and check if they are valid, then print
    //the length of the ship and the points that make up the ship
    public void placeShip(Scanner scanner) {
        int shipLength;
//        int[] userCoordinates = new int[4]; // for holding coordinates on the board
//        String errorMessage = "Error!";
//        //prompt user for coordinates
//        System.out.println("Enter the coordinates of the ship:");
//        String userInput = scanner.nextLine();
//        //validate input
//        userCoordinates = validateUserInput(userInput, errorMessage, userCoordinates);
//        //check if move was valid
//        if (userCoordinates[0] == 0 && userCoordinates[1] == 0) {
//            return;
//        } else {
//            userCoordinates = translateCoordinates(userCoordinates);
//            if (!validateMove(userCoordinates)) {
//                System.out.println(errorMessage);
//                return;
//            }
//        }
//        //output the length of the ship if valid move
//        int shipLength = calculateShipLength(userCoordinates);
//        System.out.println("Length: " + shipLength);
//        //create new Ship now that we know the length
//        Ship ship1 = new Ship(shipLength, userCoordinates);
//        ship1.printSections();
        String errorMessage = "Error!";
        System.out.println("Enter the coordinates of the ship:");
        //take in user coordinates
        try {
            StringBuilder coord1 = new StringBuilder(scanner.next().trim().toUpperCase());
            StringBuilder coord2 = new StringBuilder(scanner.next().trim().toUpperCase());
            //take first alphabetic value
            this.y1 = coord1.charAt(0);
            coord1.deleteCharAt(0);
            this.y2 = coord2.charAt(0);
            coord2.deleteCharAt(0);
            //convert remaining userinput to int for x coordinate
            this.x1 = Integer.parseInt(coord1.toString());
            this.x2 = Integer.parseInt(coord2.toString());
        } catch (Exception e) {
            System.out.println(errorMessage);
        }
        userCoordinates[0] = y1;
        userCoordinates[1] = x1;
        userCoordinates[2] = y2;
        userCoordinates[3] = x2;
        translateCoordinates(userCoordinates);
        //check if coordinates are valid
        if (!validateMove(userCoordinates)) {
            System.out.println(errorMessage);
            return;
        }
        shipLength = calculateShipLength(userCoordinates);
        System.out.println("Length: " + shipLength);
        Ship ship1 = new Ship(shipLength, userCoordinates);
        ship1.printSections();

    }
    

    //method for printing usercoordinates
    public void printCoordinates(int[] userCoordinates) {
        for (int element: userCoordinates
             ) {
            System.out.println(element);
        }
    }

    //method translates usercoordinates from char values to 1-11
    public int[] translateCoordinates(int[] userCoordinates) {
        int charToIntValue = 64;
        userCoordinates[0] = userCoordinates[0] - charToIntValue;
        userCoordinates[2] = userCoordinates[2] - charToIntValue;
        return userCoordinates;
    }

    public int calculateShipLength(int[] userCoordinates) {
        int length, x, y;
        x = userCoordinates[0] - userCoordinates[2];
        y = userCoordinates[1] - userCoordinates[3];
        length = Math.abs(x) + Math.abs(y) + 1;
        return length;
    }

    //method checks if user coordinates are out of bounds
    public boolean validateMove(int[] userCoordinates) {
        for (int i = 0; i < userCoordinates.length; i++) {
            if (userCoordinates[i] < 1 || userCoordinates[i] > 10) {
                return false;
            }
        }
        if (userCoordinates[0] != userCoordinates[2] && userCoordinates[1] != userCoordinates[3]) {
            return false;
        }
        return true;
    }

    //method checks if userinput is not correct length or not able to be parsed to an int from char
    public int[] validateUserInput(String userInput, String errorMessage, int[] userCoordinates ) {
        userInput = userInput.trim().toUpperCase();
        char temp;
        if (userInput.length() != 5) {
            System.out.println(errorMessage);
        } else {
            try {
                //get chars at index and change to ints
               userCoordinates[0] = userInput.charAt(0);
               temp = userInput.charAt(1);
               userCoordinates[1] = Character.getNumericValue(temp);
               userCoordinates[2] = userInput.charAt(3);
               temp = userInput.charAt(4);
               userCoordinates[3] = Character.getNumericValue(temp);

            } catch (Exception e) {
            System.out.println(errorMessage);
            userCoordinates[0] = 0;
            userCoordinates[1] = 0;
            userCoordinates[2] = 0;
            userCoordinates[3] = 0;
            return userCoordinates;
            }
        }
        return userCoordinates;
    }
}

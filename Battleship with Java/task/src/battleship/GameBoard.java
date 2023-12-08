package battleship;

import java.util.Scanner;

public class GameBoard {

    private String[][] board = new String[11][11];
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
        int[] userCoordinates = new int[4]; // for holding coordinates on the board
        String errorMessage = "Error!";
        //prompt user for coordinates
        System.out.println("Enter the coordinates of the ship:");
        String userInput = scanner.nextLine();
        //validate input
        userCoordinates = validateUserInput(userInput, errorMessage, userCoordinates);
        for (int point: userCoordinates) {
            System.out.println(point);
        };
    }

    public int[] validateUserInput(String userInput, String errorMessage, int[] userCoordinates ) {
        userInput = userInput.trim().toUpperCase();
        if (userInput.length() != 5) {
            System.out.println(errorMessage);
        } else {
            try {
                //get chars at index and change to ints
               userCoordinates[0] = userInput.charAt(0);
               userCoordinates[1] = userInput.charAt(1);
               userCoordinates[2] = userInput.charAt(3);
               userCoordinates[3] = userInput.charAt(4);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return userCoordinates;
    }
}

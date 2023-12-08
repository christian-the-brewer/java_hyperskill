package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameBoard p1Board = new GameBoard();
        p1Board.printBoard();
        p1Board.placeShip(scanner);
    }
}

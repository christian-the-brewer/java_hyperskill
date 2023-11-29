import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int userInput;
        String message = new String();
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextInt();
        message = switch (userInput) {
            case 1 -> "You have chosen a square";
            case 2 -> "You have chosen a circle";
            case 3 -> "You have chosen a triangle";
            case 4 -> "You have chosen a rhombus";
            default -> "There is no such shape!";
        };
        System.out.println(message);
    }
}
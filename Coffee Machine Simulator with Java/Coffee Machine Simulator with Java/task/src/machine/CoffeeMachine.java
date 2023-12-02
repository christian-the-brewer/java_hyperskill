package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        boolean menuIsOpen = true;
        String userInput;

        CoffeeMaker maker = new CoffeeMaker();


        Scanner scanner = new Scanner(System.in);

        while (menuIsOpen) {
            System.out.println("Write action (buy, fill, take):");
            switch (scanner.nextLine()) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    userInput = scanner.nextLine();
                    if (userInput.equals("back")) {
                        break;
                    } else {
                        maker.buyDrink(Integer.parseInt(userInput));
                    }
                    break;
                case "fill":
                    maker.fillMachine(scanner);
                    break;
                case "take":
                    maker.takeMoney(scanner);
                    break;
                case "remaining":
                    maker.printSupplies();
                    break;
                case "exit":
                    menuIsOpen = false;
                    break;
                default:
                    break;
            }
        }



    }


}

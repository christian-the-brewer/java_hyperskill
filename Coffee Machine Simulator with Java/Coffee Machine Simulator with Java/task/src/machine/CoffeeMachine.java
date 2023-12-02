package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        CoffeeMaker maker = new CoffeeMaker();


        Scanner scanner = new Scanner(System.in);

        maker.printSupplies();
        System.out.println("Write action (buy, fill, take):");
        switch (scanner.nextLine()) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                maker.buyDrink(scanner.nextInt());
                break;
            case "fill":
                maker.fillMachine(scanner);
                break;
            case "take":
                maker.takeMoney(scanner);
                break;
            default:
                break;
        }
        maker.printSupplies();


    }


}

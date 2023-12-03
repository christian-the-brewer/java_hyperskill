package machine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class CoffeeMaker {
    private final int coffeePerCup = 15;
    private final int waterPerCup = 200;
    private final int milkPerCup = 50;

    int water = 400, coffee = 120, milk = 540, disposableCups = 9, money = 550;



    public CoffeeMaker() {

    }

    public int getMaxCups() {
        int[] cupsForSupplies = {getWater() / waterPerCup, getCoffee() / coffeePerCup, getMilk() / milkPerCup, getDisposableCups()};

        Arrays.sort(cupsForSupplies);
        return cupsForSupplies[0];
    }


    public void setWater(int water) {
        this.water = water;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    private int getDisposableCups() {
        return this.disposableCups;
    }


    public void checkIngredients(Scanner scanner) {
        System.out.println("Write how many ml of water the coffee machine has:");
        setWater(scanner.nextInt());
        System.out.println("Write how many ml of milk the coffee machine has:");
        setMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        setCoffee(scanner.nextInt());
        System.out.println("Write how many cups of coffee you will need:");
        int maxCups = getMaxCups();
        int requestedCups = scanner.nextInt();
        if (maxCups == requestedCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > requestedCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that%n", maxCups - requestedCups);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", maxCups);
        }
    }
}

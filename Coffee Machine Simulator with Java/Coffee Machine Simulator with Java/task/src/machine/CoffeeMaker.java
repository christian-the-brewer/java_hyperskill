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

    Drink espresso = new Drink(250, 0, 16, 4);
    Drink latte = new Drink(350, 75, 20, 7);
    Drink cappuccino = new Drink(200, 100, 12, 6);

    public int getMaxCups() {
        int[] cupsForSupplies = {getWater() / waterPerCup, getCoffee() / coffeePerCup, getMilk() / milkPerCup, getDisposableCups()};

        Arrays.sort(cupsForSupplies);
        return cupsForSupplies[0];
    }


    public void setWater(int water) {
        this.water += water;
    }

    public void setCoffee(int coffee) {
        this.coffee += coffee;
    }

    public void setMilk(int milk) {
        this.milk += milk;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups += disposableCups;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
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

    private int getMoney() {
        return this.money;
    }

    public void buyDrink(int drink) {
        int waterNeeded = 0, milkNeeded = 0, coffeeNeeded = 0, cost = 0;
        switch (drink) {
            case 1:
                waterNeeded = espresso.getWater();
                milkNeeded = espresso.getMilk();
                coffeeNeeded = espresso.getCoffee();
                cost = espresso.getCost();
                break;
            case 2:
                waterNeeded = latte.getWater();
                milkNeeded = latte.getMilk();
                coffeeNeeded = latte.getCoffee();
                cost = latte.getCost();
                break;
            case 3:
                waterNeeded = cappuccino.getWater();
                milkNeeded = cappuccino.getMilk();
                coffeeNeeded = cappuccino.getCoffee();
                cost = cappuccino.getCost();
                break;
            default:
                break;
        }
        if (enoughSuppliesForDrink(waterNeeded, milkNeeded, coffeeNeeded)) {
            addMoney(cost);
            setWater(-waterNeeded);
            setMilk(-milkNeeded);
            setCoffee(-coffeeNeeded);
            setDisposableCups(-1);
        }
    }

    public boolean enoughSuppliesForDrink(int waterNeeded, int milkNeeded, int coffeeNeeded) {
        if (getDisposableCups() < 1) {
            return false;
        } else if (waterNeeded > getWater() || milkNeeded > getMilk() || coffeeNeeded > getCoffee()) {
            return false;
        } else {
            return true;
        }

    }

    public void printSupplies() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", getWater());
        System.out.printf("%d ml of milk%n", getMilk());
        System.out.printf("%d g of coffee beans%n", getCoffee());
        System.out.printf("%d disposable cups%n", getDisposableCups());
        System.out.printf("$%d of money%n", getMoney());
    }

    public void takeMoney(Scanner scanner) {
        System.out.printf("I gave you $%d%n", getMoney());
        setMoney(0);
    }

    public void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        setWater(scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        setMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        setCoffee(scanner.nextInt());
        System.out.println("Write how many disposable cups you want to add:");
        setDisposableCups(scanner.nextInt());
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

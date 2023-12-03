package machine;

public class Drink {
    private int water, milk, coffee, cost;
    public Drink(int water, int milk, int coffee, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cost = cost;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    public int getCost() {
        return cost;
    }
}

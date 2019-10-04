package machine.coffees;

public abstract class Coffee {
    private int neededWater;
    private int milkSupply;
    private int neededCoffee;
    private int price;

    protected Coffee(int water, int milk, int coffee, int price) {
        this.neededWater = water;
        this.milkSupply = milk;
        this.neededCoffee = coffee;
        this.price = price;
    }

    public int getNeededWater() {
        return neededWater;
    }

    public int getNeededMilk() {
        return milkSupply;
    }

    public int getNeededCoffee() {
        return neededCoffee;
    }

    public int getPrice() {
        return price;
    }
}

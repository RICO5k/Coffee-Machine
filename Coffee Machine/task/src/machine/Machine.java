package machine;

import machine.coffees.Coffee;

public class Machine {

    private int waterSupply;
    private int milkSupply;
    private int coffeeSupply;
    private int cups;
    private int money;

    public Machine(int water, int milk, int coffee, int cups, int money) {
        this.waterSupply = water;
        this.milkSupply = milk;
        this.coffeeSupply = coffee;
        this.cups = cups;
        this.money = money;
    }

    public void buyCoffee(Coffee coffee) {
        if(hasEnoughIngredients(coffee)) {
            getPayment(coffee);
            makeCoffee(coffee);
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        if(waterSupply < coffee.getNeededWater()) {
            return false;
        } else if(milkSupply < coffee.getNeededMilk()) {
            return false;
        } else if(coffeeSupply < coffee.getNeededCoffee()) {
            return false;
        }
        return cups > 0;
    }

    private void getPayment(Coffee coffee) {
        this.money += coffee.getPrice();
    }

    private void makeCoffee(Coffee coffee) {
        this.waterSupply -= coffee.getNeededWater();
        this.milkSupply -= coffee.getNeededMilk();
        this.coffeeSupply -= coffee.getNeededCoffee();
        this.cups--;
    }

    public int takeMoney() {
        int temp = money;
        this.money = 0;

        return temp;
    }

    public void refill(int water, int milk, int coffee, int cups) {
        this.waterSupply += water;
        this.milkSupply += milk;
        this.coffeeSupply += coffee;
        this.cups += cups;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("The coffee machine has:\n");
        sb.append(waterSupply + " of water\n");
        sb.append(milkSupply + " of milk\n");
        sb.append(coffeeSupply + " of coffee beans\n");
        sb.append(cups + " of disposable cups\n");
        sb.append(money + " of money\n");

        return sb.toString();
    }
}

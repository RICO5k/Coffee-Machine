package machine;

import machine.coffees.CappuccinoCoffee;
import machine.coffees.Coffee;
import machine.coffees.EspressoCoffee;
import machine.coffees.LatteCoffee;

import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Machine coffeeMachine = new Machine(1200, 540, 120, 9, 550);

        System.out.println(coffeeMachine);

        System.out.print("Write action (buy, fill, take): ");
        String action = scanner.nextLine();

        if(action.equals("buy")) {
            buy(coffeeMachine);
        } else if(action.equals("fill")) {
            fill(coffeeMachine);
        } else if(action.equals("take")) {
            take(coffeeMachine);
        } else {
            System.out.println("unknown action");
        }

        System.out.println(coffeeMachine);
    }

    public static void buy(Machine coffeeMachine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int choice = Integer.parseInt(scanner.nextLine());

        Coffee coffee = null;

        switch(choice) {
            case 1:
                coffee = EspressoCoffee.getInstance();
            break;
            case 2:
                coffee = LatteCoffee.getInstance();
            break;
            case 3:
                coffee = CappuccinoCoffee.getInstance();
            break;
        }

        if(coffee != null) {
            coffeeMachine.buyCoffee(coffee);
        }
    }

    public static void fill(Machine coffeeMachine) {
        System.out.print("Write how many ml of water do you want to add: ");
        int water = Integer.parseInt(scanner.nextLine());
        System.out.print("Write how many ml of milk do you want to add: ");
        int milk = Integer.parseInt(scanner.nextLine());
        System.out.print("Write how many grams of coffee do you want to add: ");
        int coffee = Integer.parseInt(scanner.nextLine());
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        int cups = Integer.parseInt(scanner.nextLine());

        coffeeMachine.refill(water, milk, coffee, cups);
    }

    public static void take(Machine coffeeMachine) {
        coffeeMachine.takeMoney();
    }
}

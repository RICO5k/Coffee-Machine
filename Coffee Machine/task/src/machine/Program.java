package machine;

import machine.coffees.CappuccinoCoffee;
import machine.coffees.Coffee;
import machine.coffees.EspressoCoffee;
import machine.coffees.LatteCoffee;

import java.util.Scanner;

public class Program {
    private Scanner scanner;
    private Machine coffeeMachine;

    private boolean running;

    public Program(Scanner scanner) {
        this.scanner = scanner;
        this.coffeeMachine = new Machine(400, 540, 120, 9, 550);
    }

    public void run() {
        this.running = true;

        while(this.running) {
            Actions action = chooseAction();
            executeAction(action);
        }
    }

    private Actions chooseAction() {
        System.out.print("\nWrite action (buy, fill, take, remaining, exit): ");
        String choice = scanner.nextLine();

        System.out.print("\n\n");

        Actions action;

        try {
            action =  Actions.valueOf(choice.toUpperCase());
        } catch(Exception e) {
            action = Actions.UNDEFINED;
        }

        return action;
    }

    private void executeAction(Actions action) {
        switch(action) {
            case BUY: buy(); break;
            case FILL: fill(); break;
            case TAKE: take(); break;
            case REMAINING: remaining(); break;
            case EXIT: exit(); break;
            default:
        }
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch(Exception e) {
            return;
        }

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

    private void fill() {
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

    private void take() {
        coffeeMachine.takeMoney();
    }

    private void remaining() {
        System.out.println(coffeeMachine);
    }

    private void exit() {
        this.running = false;
    }
}

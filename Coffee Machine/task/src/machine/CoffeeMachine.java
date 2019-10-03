package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int waterForOneCoffee = 200;
        final int milkForOneCoffee = 50;
        final int coffeeBeansForOneCoffee = 15;

        System.out.print("Write how many ml of water the coffee machine has: ");
        int waterSupplies = scanner.nextInt();

        System.out.print("\nhow many ml of milk the coffee machine has: ");
        int milkSupplies = scanner.nextInt();

        System.out.print("\nWrite how many grams of coffee beans the coffee machine has: ");
        int coffeeBeansSupplies = scanner.nextInt();

        System.out.print("\nWrite how many cups of coffee you will need: ");
        int coffeeCups = scanner.nextInt();

        int maxNumOfCups = Math.min(Math.min(waterSupplies/waterForOneCoffee, milkSupplies/milkForOneCoffee), coffeeBeansSupplies/coffeeBeansForOneCoffee);

        if(maxNumOfCups < coffeeCups) {
            System.out.printf("\nNo, I can make only %d cup(s) of coffee", maxNumOfCups);
        } else if(maxNumOfCups == coffeeCups) {
            System.out.print("\nYes, I can make that amount of coffee");
        } else {
            System.out.printf("\nYes, I can make that amount of coffee (and even %d more than that)", (maxNumOfCups-coffeeCups));
        }
    }
}

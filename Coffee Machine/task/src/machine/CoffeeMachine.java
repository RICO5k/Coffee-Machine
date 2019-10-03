package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waterForOneCoffee = 200;
        int milkForOneCoffee = 50;
        int coffeeBeansForOneCoffee = 15;

        System.out.print("Write how many cups of coffee you will need: ");
        int coffeeCups = scanner.nextInt();

        System.out.println("For " + coffeeCups + " cups of coffee you will need:");
        System.out.println(waterForOneCoffee * coffeeCups + " ml of water");
        System.out.println(milkForOneCoffee * coffeeCups + " ml of milk");
        System.out.println(coffeeBeansForOneCoffee * coffeeCups + " g of coffee beans");
    }
}

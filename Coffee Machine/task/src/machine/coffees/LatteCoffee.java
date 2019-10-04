package machine.coffees;

public class LatteCoffee extends Coffee {

    private static Coffee instance = null;

    private LatteCoffee() {
        super(350, 75, 20, 7);
    }

    public static Coffee getInstance() {
        if(instance == null) {
            instance = new LatteCoffee();
        }

        return instance;
    }

}

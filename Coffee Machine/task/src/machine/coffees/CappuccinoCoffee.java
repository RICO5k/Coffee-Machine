package machine.coffees;

public class CappuccinoCoffee extends Coffee {

    private static Coffee instance = null;

    private CappuccinoCoffee() {
        super(200, 100, 12, 6);
    }

    public static Coffee getInstance() {
        if(instance == null) {
            instance = new CappuccinoCoffee();
        }

        return instance;
    }

}

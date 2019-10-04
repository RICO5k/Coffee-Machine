package machine.coffees;

public class EspressoCoffee extends Coffee {

    private static Coffee instance = null;

    private EspressoCoffee() {
        super(250, 0, 16, 4);
    }

    public static Coffee getInstance() {
        if(instance == null) {
            instance = new EspressoCoffee();
        }

        return instance;
    }

}

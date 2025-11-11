interface Engine {
    public abstract void move();
}

interface Driver {
    public abstract void navigate();
}

class CombustionEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Combustion engine is moving the vehicle.");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Electric engine is moving the vehicle.");
    }
}

class Human implements Driver {
    @Override
    public void navigate() {
        System.out.println("Human driver is navigating the vehicle.");
    }
}

class Robot implements Driver {
    @Override
    public void navigate() {
        System.out.println("Robot driver is navigating the vehicle.");
    }
}

class Transport {
    private Engine engine;
    private Driver driver;

    public Transport(Engine e, Driver d) {
        this.engine = e;
        this.driver = d;
    }

    public void deliver(String destination, String cargo) {
        System.out.println("\n--- Starting Delivery ---");
        System.out.println("Cargo: " + cargo);
        System.out.println("Destination: " + destination);

        engine.move();
        driver.navigate();

        System.out.println("Delivery completed successfully!");
    }
}

public class Composition {
    public static void main(String[] args) {
        System.out.println("--- Composition Pattern ---");

        Engine electric = new ElectricEngine();
        Driver robot = new Robot();
        Transport selfDrivingTruck = new Transport(electric, robot);
        selfDrivingTruck.deliver("Karachi", "Medical Supplies");

        Engine combustion = new CombustionEngine();
        Driver human = new Human();
        Transport regularCar = new Transport(combustion, human);
        regularCar.deliver("Islamabad", "Furniture");
    }
}

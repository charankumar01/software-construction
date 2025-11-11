import java.util.ArrayList;
import java.util.List;

interface Shipping {
    public abstract double getCost(Order order);

    public abstract String getDate(Order order);
}

class Ground implements Shipping {
    @Override
    public double getCost(Order order) {
        if (order.getTotal() > 100) {
            return 0.0;
        }
        double cost = order.getTotalWeight() * 1.5;
        return Math.max(10.0, cost);
    }

    @Override
    public String getDate(Order order) {
        return "3-5 business days (Ground)";
    }
}

class Air implements Shipping {
    @Override
    public double getCost(Order order) {
        return order.getTotalWeight() * 5.0 + 5.0;
    }

    @Override
    public String getDate(Order order) {
        return "1-2 business days (Air)";
    }
}

class Order {

    private List<String> lineItems = new ArrayList<>();
    private Shipping shipping;

    public Order(Shipping shipping) {
        this.shipping = shipping;
    }

    public void setShippingType(Shipping newShipping) {
        this.shipping = newShipping;
    }

    public void addLineItem(String item) {
        this.lineItems.add(item);
    }

    public double getTotal() {
        return 120.0;
    }

    public double getTotalWeight() {
        return 8.0;
    }

    public double getShippingCost() {
        return shipping.getCost(this);
    }

    public String getShippingDate() {
        return shipping.getDate(this);
    }

    @Override
    public String toString() {
        return "Order (Total: $" + getTotal() + ", Weight: " + getTotalWeight() + "kg)";
    }
}

public class Strategy {
    public static void main(String[] args) {
        System.out.println("--- Strategy Pattern ---");

        System.out.println("\n--- Order 1: Big Order (Ground Shipping) ---");
        Order bigOrder = new Order(new Ground());

        System.out.println(bigOrder);
        System.out.println("Shipping Cost: $" + bigOrder.getShippingCost());
        System.out.println("Delivery Date: " + bigOrder.getShippingDate());

        bigOrder.setShippingType(new Air());
        System.out.println("\n--- Order 1: Changed to Air Shipping ---");
        System.out.println("Shipping Cost: $" + bigOrder.getShippingCost());
        System.out.println("Delivery Date: " + bigOrder.getShippingDate());
    }
}

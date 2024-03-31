import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

// Pizza class
class Pizza {
    private String type;
    private double basePrice;
    private ArrayList<String> addOns;
    private boolean takeaway;

    // Constructor
    public Pizza(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
        this.addOns = new ArrayList<>();
        this.takeaway = false;
    }

    // Method to add add-ons
    public void addAddOn(String addOn) {
        addOns.add(addOn);
     //   System.out.println(addOn);
    }

    // Method to set takeaway option
    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }

    // Method to calculate bill
    public double calculateBill() {
        double bill = basePrice;

        // Add extra charge for each add-on
        for (String addOn : addOns) {
            bill += 100; // Add-on charge: 100 rupees each
        }

        // Add takeaway charge if applicable
        if (takeaway) {
            bill += 20; // Takeaway charge: 20 rupees
        }

        return bill;
    }
}

// DeluxePizza class inheriting from Pizza
class DeluxePizza extends Pizza {
    // Constructor
    public DeluxePizza(String type, double basePrice) {
        super(type, basePrice);
        addAddOn("Extra Cheese"); // Automatically include extra cheese
        addAddOn("Extra Toppings"); // Automatically include extra toppings
    }
}

// Main class
public class PizzaBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu : \n 1.Normal Pizza \n 2.Deluxe Pizza" );
        System.out.println(" ==>Select 1 for Normal Pizza \n ==>Select 2 for Deluxe Pizza  ");
        int select = sc.nextInt();
        if(select == 1) {
            System.out.println("==>Select v for veg Pizza \n ==>select n for non veg pizza ");
            String sel = sc.next();
            if(sel.equals("v")) {
                // Creating a normal veg pizza
                Pizza vegPizza = new Pizza("Veg", 300);

                System.out.println("do you want Extra chees (y/n) :");
                String ch = sc.next();
                if (ch.equals("y"))
                    vegPizza.addAddOn("Extra Cheese");

                System.out.println("do you want Extra Toopings (y/n) :");
                String ch1 = sc.next();
                if (ch1.equals("y"))
                    vegPizza.addAddOn("Extra Toppings");

                System.out.println("want to takeway (y/n):");
                String ch2 = sc.next();
                if (ch2.equals("y"))
                    vegPizza.setTakeaway(true);

                double vegPizzaBill = vegPizza.calculateBill();
                System.out.println("Veg Pizza Bill: " + vegPizzaBill + " rupees");
            }
            else if(sel.equals("n")) {
                // Creating a normal veg pizza
                Pizza vegPizza = new Pizza("Non-Veg", 300);

                System.out.println("do you want Extra chees (y/n) :");
                String ch = sc.next();
                if (ch.equals("y"))
                    vegPizza.addAddOn("Extra Cheese");

                System.out.println("do you want Extra Toopings (y/n) :");
                String ch1 = sc.next();
                if (ch1.equals("y"))
                    vegPizza.addAddOn("Extra Toppings");

                System.out.println("want to takeway (y/n):");
                String ch2 = sc.next();
                if (ch2.equals("y"))
                    vegPizza.setTakeaway(true);

                double vegPizzaBill = vegPizza.calculateBill();
                System.out.println("Veg Pizza Bill: " + vegPizzaBill + " rupees");
            }
        }
        else if(select == 2) {
            System.out.println("==>Select v for veg Pizza \n ==>select n for non veg pizza ");
            String sel = sc.next();
            // Creating a deluxe non-veg pizza
            if(sel.equals("v")){
                DeluxePizza nonVegDeluxePizza = new DeluxePizza("Veg Deluxe", 400);

                System.out.println("want to takeway (y/n):");
                String ch2 = sc.next();
                if (ch2.equals("y"))
                    nonVegDeluxePizza.setTakeaway(true);

                double nonVegDeluxePizzaBill = nonVegDeluxePizza.calculateBill();
                System.out.println("Non-Veg Deluxe Pizza Bill: " + nonVegDeluxePizzaBill + " rupees");
            }
            else if(sel.equals("n")) {
                DeluxePizza nonVegDeluxePizza = new DeluxePizza("Non-Veg Deluxe", 400);

                System.out.println("want to takeway (y/n):");
                String ch2 = sc.next();
                if (ch2.equals("y"))
                    nonVegDeluxePizza.setTakeaway(true);

                double nonVegDeluxePizzaBill = nonVegDeluxePizza.calculateBill();
                System.out.println("Non-Veg Deluxe Pizza Bill: " + nonVegDeluxePizzaBill + " rupees");
            }
        }
        // Calculating bills
       // double vegPizzaBill = vegPizza.calculateBill();
        //double nonVegDeluxePizzaBill = nonVegDeluxePizza.calculateBill();

        // Displaying bills
        //System.out.println("Veg Pizza Bill: " + vegPizzaBill + " rupees");
        //System.out.println("Non-Veg Deluxe Pizza Bill: " + nonVegDeluxePizzaBill + " rupees");
    }
}

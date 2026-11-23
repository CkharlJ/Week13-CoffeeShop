package coffeeshop;

import java.util.ArrayList;

// STEP 5 · CoffeeShop: the shop, its menu, and every order it finished today.
//
// Open UML.md and find "Step 5 · CoffeeShop".
//   4 private fields: name, menu, completedOrders, totalSales
//   1 constructor:    CoffeeShop(String name)
//   7 methods:        getName(), getMenu(), checkout(), getOrdersCompleted(),
//                     getTotalSales(), getItemsSold(), salesReport()
//
// Then drag check/coffeeshop/CoffeeShopTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 5: CoffeeShop

public class CoffeeShop {
    private String name;
    private Menu menu;
    private ArrayList<Order> completedOrders;
    private double totalSales;

    // Creates the shop with a menu and no sales.
    public CoffeeShop(String name) {
        this.name = name;
        menu = new Menu();
        completedOrders = new ArrayList<>();
        totalSales = 0.0;
    }

    // Returns the name of the shop.
    public String getName() {
        return name;
    }

    // Returns the shop's menu.
    public Menu getMenu() {
        return menu;
    }

    // Completes an order and records its total.
    public double checkout(Order order, int tipPercent) {
        if (order.isEmpty()) {
            return 0.0;
        }

        double total = order.getTotal(tipPercent);

        completedOrders.add(order);
        totalSales += total;

        return total;
    }

    // Returns the number of completed orders.
    public int getOrdersCompleted() {
        return completedOrders.size();
    }

    // Returns the total money earned.
    public double getTotalSales() {
        return totalSales;
    }

    // Counts all items sold in completed orders.
    public int getItemsSold() {
        int count = 0;

        for (Order order : completedOrders) {
            count += order.getItemCount();
        }

        return count;
    }

    // Displays a summary of today's sales.
    public String salesReport() {
        return name + " - today's sales\n"
                + "  Orders: " + getOrdersCompleted() + "\n"
                + "  Items sold: " + getItemsSold() + "\n"
                + "  Total: $"
                + String.format("%.2f", totalSales);
    }
}

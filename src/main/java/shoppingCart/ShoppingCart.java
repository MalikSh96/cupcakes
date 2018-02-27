package shoppingCart;

import LineItems.LineItems;
import java.util.ArrayList;

public class ShoppingCart {

    private int price;
    LineItems lineItem = new LineItems();
    ArrayList<String> lineItems = new ArrayList<>();

    private ArrayList<String> shoppingCart(String line) {

        lineItems.add(line);

        return lineItems;
    }
}

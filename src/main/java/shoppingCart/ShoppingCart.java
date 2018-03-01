package shoppingCart;

import cupcake.Cupcake;
import databaseConnect.DAO;
import java.util.ArrayList;

public class ShoppingCart {

    private int totalPrice;
    ArrayList<Cupcake> shoppingCart = new ArrayList<>();
    DAO dao;
    Cupcake cake = new Cupcake(dao.getCakeTopping("derp"), dao.getCakeBottom("derp"), 
            dao.getCakeTopping("derp").getTopping_price(), dao.getCakeBottom("derp").getBottom_price());
    
    private void shoppingCartAdd(Cupcake cake) {

        shoppingCart.add(cake);
        totalPrice += cake.getToppingPrice() + cake.getBottomPrice();
        System.out.println(totalPrice);
    }
}

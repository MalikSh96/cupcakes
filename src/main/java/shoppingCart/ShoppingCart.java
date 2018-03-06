package shoppingCart;

import cupcake.Cupcake;
import databaseConnect.DAO;
import java.util.ArrayList;

public class ShoppingCart 
{
    private int totalPrice;
    ArrayList<Cupcake> shoppingCart = new ArrayList<>();
    DAO dao;


    public ArrayList<Cupcake> getShoppingCart() 
    {
        return shoppingCart;
    }
    
    
    public void shoppingCartAdd(Cupcake cake) 
    {
        
    }

    
    public void shoppingCartAdd(Cupcake cake, int amount) 
    {
//        for (int i = 0; i < amount; i++) 
//        {
//            
//        }
        shoppingCart.add(cake);

        totalPrice += cake.getTopping().getTopping_price() + cake.getBottom().getBottom_price();
//        for (int i = 0; i < shoppingCart.size(); i++) 
//        {
//            
//        
//        }
       //totalPrice += (cake.getToppingPrice() + cake.getBottomPrice())*amount;
        for (int i = 0; i < shoppingCart.size(); i++) 
        {
            System.out.println(shoppingCart.get(i).toString());
        }
    }

    public int getTotalPrice() 
    {
        return totalPrice;
    }

    @Override
    public String toString() 
    {
        return "ShoppingCart totalPrice: " + totalPrice + "\nshoppingCart: " + shoppingCart;
    }
}

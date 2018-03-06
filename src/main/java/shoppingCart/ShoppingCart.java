package shoppingCart;

import cupcake.Cupcake;
import databaseConnect.DAO;
import java.util.ArrayList;

public class ShoppingCart 
{
    private int totalPrice;
    ArrayList<Cupcake> cupcakes = new ArrayList<>();
    DAO dao;
    private int id;

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public ArrayList<Cupcake> getCupcakes() 
    {
        return cupcakes;
    }
    
    
    public void shoppingCartAdd(Cupcake cake) 
    {
        
    }

    
    public void cupcakeAdd(Cupcake cake) 
    {
//        for (int i = 0; i < amount; i++) 
//        {
//            
//        }
        cupcakes.add(cake);

        totalPrice += cake.getTopping().getTopping_price() + cake.getBottom().getBottom_price();
//        for (int i = 0; i < cupcakes.size(); i++) 
//        {
//            
//        
//        }
       totalPrice += (cake.getTopping().getTopping_price() + cake.getBottom().getBottom_price()) * cake.getAmount();
        for (int i = 0; i < cupcakes.size(); i++) 
        {
            System.out.println(cupcakes.get(i).toString());
        }
    }

    public int getTotalPrice() 
    {
        return totalPrice;
    }

    @Override
    public String toString() 
    {
        return "ShoppingCart totalPrice: " + totalPrice + "\nshoppingCart: " + cupcakes;
    }
}

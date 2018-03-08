package shoppingCart;

import cupcake.Cupcake;
import cupcake.CupcakeList;
import java.util.ArrayList;
import databaseConnect.DAO;
import datasource.DataSource1;

public class ShoppingCart 
{
    private int totalPrice = 0;
            private int id, pris, amount;
    private int fullPrice = 0;
    ArrayList<Cupcake> shoppingCart = new ArrayList<>();
    public ArrayList<CupcakeList> cupcakeList = new ArrayList<>();
    DataSource1 ds = new DataSource1();
    DAO dao = new DAO(ds.getDataSource());


    public void shoppingCartAdd(Cupcake cake, int amount) {
        
            
        shoppingCart.add(cake);
        cupcakeList.add(new CupcakeList(cake.getTopping().toString(),cake.getBottom().toString(),amount,(cake.getTopping().getTopping_price() + cake.getBottom().getBottom_price())*amount));
            
       
        totalPrice += (cake.getPrice())*amount;
    }
    
    public int getTotalPrice() 
    {
        return totalPrice;
    }

    public ArrayList<Cupcake> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Cupcake> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String toString(String top, String bottom, int amount, int pris, int fullPrice) {  
        return "Topping: " + top + "<br>Bottom: " + bottom +  "<br>Amount: " + amount + "<br>Price: " + pris + "<br>Total Price: " + fullPrice;
    }
}

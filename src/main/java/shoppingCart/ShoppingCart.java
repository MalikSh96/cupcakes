package shoppingCart;

import cupcake.Cupcake;
import cupcake.CupcakeList;
import java.util.ArrayList;
import databaseConnect.DAO;
import datasource.DataSource1;

public class ShoppingCart 
{
    private int totalPrice;
    private int id;
    public ArrayList<Cupcake> shoppingCart = new ArrayList<>();
    DataSource1 ds = new DataSource1();
    DAO dao = new DAO(ds.getDataSource());

    public void cupcakeAdd(Cupcake cake) 
    {        
        shoppingCart.add(cake);
        totalPrice += (cake.getPrice())*cake.getAmount();
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
    
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public String toString(String top, String bottom, int amount, int pris, int fullPrice) {  
        return "Topping: " + top + "<br>Bottom: " + bottom +  "<br>Amount: " + amount + "<br>Price: " + pris + "<br>Total Price: " + fullPrice;
    }
}

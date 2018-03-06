package shoppingCart;

import cupcake.Cupcake;
import cupcake.CupcakeList;
import java.util.ArrayList;
import databaseConnect.DAO;
import datasource.DataSource1;

public class ShoppingCart 
{
    private int totalPrice, id, pris, amount;
            int fullPrice = 0;
    ArrayList<Cupcake> shoppingCart = new ArrayList<>();
    public ArrayList<CupcakeList> cupcakeList = new ArrayList<>();
    DataSource1 ds = new DataSource1();
    DAO dao = new DAO(ds.getDataSource());


    public void shoppingCartAdd(Cupcake cake, int amount) {
        
            
        shoppingCart.add(cake);
        cupcakeList.add(new CupcakeList(cake.getTopping().toString(),cake.getBottom().toString(),amount,(cake.getTopping().getTopping_price() + cake.getBottom().getBottom_price())*amount));
            
       
        totalPrice += (cake.getTopping().getTopping_price() + cake.getBottom().getBottom_price())*amount;
//        for (int i = 0; i < shoppingCart.size(); i++) {
//            System.out.println(shoppingCart.get(i).toString());
//        }
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

    @Override
    public String toString() {
        for (int i = 0; i < shoppingCart.size(); i++) {
            
        
        return shoppingCart.get(i).toString();
    } 
        return "";
    }
    
    public String toString2() {
        for (int i = 0; i < shoppingCart.size(); i++) {
            
           String top = shoppingCart.get(i).getTopping().toString();
           String bottom = shoppingCart.get(i).getBottom().toString();
           pris = dao.getCakeBottomPrice(bottom.toString()) + dao.getCakeToppingPrice(top.toString());
           amount = shoppingCart.get(i).getAmount();
           fullPrice = pris*amount;
        
        return "Topping: " + top + "<br>Bottom: " + bottom +  "<br>Amount: " + amount + "<br>Price: " + pris + "<br>Total Price: " + fullPrice;
    } 
        return "";
    }
}

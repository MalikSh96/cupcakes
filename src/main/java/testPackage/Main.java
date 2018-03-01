package testPackage;

import cupcake.Cake_bottoms;
import cupcake.Cupcake;
import databaseConnect.DAO;
import datasource.DataSource1;
import entity.Users;
import shoppingCart.ShoppingCart;

public class Main 
{    
    public static void main(String[] args) 
    {
        DataSource1 ds1 = new DataSource1(); 
        DAO d = new DAO(ds1.getDataSource());
        ShoppingCart shop = new ShoppingCart();
//        
//        System.out.println(d.getCakeBottom("Vanilla"));
//        System.out.println(d.getCakeTopping("Blueberry"));
//        
//        System.out.println("\n " + d.getAllBottoms());
//        System.out.println("\n " + d.getAllToppings());
//        
//        System.out.println("\n " + d.createUser(new Users("Mester", 0, "9999", 100, true)));
//        System.out.println("\n\n" + d.getUser("Mester"));
//        
//        System.out.println("\n " + d.createUser(new Users("Man", 0, "8888", 200, false)));
//        System.out.println("\n\n" + d.getUser("Man"));
//       
//        Users mest = d.getUser("Mester");        
//        System.out.println("\n\n" + d.updateUser(mest.getId(), "M"));
//        
//        System.out.println("\n" + d.getUser("M"));
//        
//        System.out.println("\n" + d.getUser(4));
//        
//        System.out.println("\n\n" + d.getUsers());
//        
//        System.out.println("\n\n" + d.deleteUser(1));
        
        shop.shoppingCartAdd(new Cupcake(d.getCakeTopping("Chocolate"), d.getCakeBottom("Almond"), 
            d.getCakeTopping("Chocolate").getTopping_price(), d.getCakeBottom("Almond").getBottom_price()));
        
    }
}

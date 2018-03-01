package testPackage;

import cupcake.Cake_bottoms;
import databaseConnect.DAO;
import datasource.DataSource1;
import entity.Users;

public class Main 
{    
    public static void main(String[] args) 
    {
        DataSource1 ds1 = new DataSource1(); 
        DAO d = new DAO(ds1.getDataSource());
        
        System.out.println(d.getCakeBottom("Vanilla"));
        System.out.println(d.getCakeTopping("Blueberry"));
        
        System.out.println("\n " + d.getAllBottoms());
        System.out.println("\n " + d.getAllToppings());
        
        System.out.println("\n " + d.createUser(new Users("Mester", 0, "9999", 100, true)));
        System.out.println("\n\n" + d.getUser("Mester"));
        
        System.out.println("\n " + d.createUser(new Users("Man", 0, "8888", 200, false)));
        System.out.println("\n\n" + d.getUser("Man"));
       
        Users mest = d.getUser("Mester");        
        System.out.println("\n\n" + d.updateUser(mest.getId(), "M"));
        
        System.out.println("\n" + d.getUser("M"));
        
        System.out.println("\n" + d.getUser(4));
        
        System.out.println("\n\n" + d.getUsers());
        
        System.out.println("\n\n" + d.deleteUser(1));
    }
}

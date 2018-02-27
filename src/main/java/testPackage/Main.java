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
        
//        System.out.println("\n " + d.getAllBottoms());
//        System.out.println("\n " + d.getAllToppings());
        System.out.println("\n " + d.createUser(new Users("Mester", 8, "9999", 100, true)));
    }
}

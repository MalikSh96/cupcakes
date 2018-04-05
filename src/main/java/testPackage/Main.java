package testPackage;

import calculator.Calculator;
import cupcake.Cupcake;
import databaseConnect.DAO;
import datasource.DataSource1;
import entity.Admin;
import entity.Users;
import shoppingCart.ShoppingCart;

public class Main {

    public static void main(String[] args) throws Exception {
        DataSource1 ds1 = new DataSource1();
        DAO d = new DAO(ds1.getDataSource());
        Calculator calc = new Calculator();

        
        ShoppingCart shop = new ShoppingCart();
    //    shop.cupcakeAdd(new Cupcake(d.getCakeTopping("Chocolate"), d.getCakeBottom("Vanilla"), 30));
     //   shop.cupcakeAdd(new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Vanilla"), 120));
        int price = (d.getCakeBottom("Chocolate").getBottom_price() + d.getCakeTopping("Blueberry").getTopping_price());
        shop.cupcakeAdd(new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Chocolate"), price, 30));
     
        Users u = d.getUser(1);
        u.setCart(shop);
        System.out.println(u.getBalance());
        System.out.println("...Before..." + d.getUserBalance(u));
        System.out.println("Balance: " + calc.calculatePrice(u));
        d.updateUserBalance(u);
        System.out.println("...After..." + d.getUserBalance(u));
        
        System.out.println("\n\nOrderline here");
        System.out.println(d.orderID(u));
        
//        Users u = new Users("john", "flaske", 2200, 5);
//        Admin ad = new Admin();
//        ShoppingCart cart = new ShoppingCart();
//        Users us = d.getUser(4);

//        ad.printUsers();
//        System.out.println(u.getId());
//        u.setId(u);
//        System.out.println(u.getId());
//
//        shop.cupcakeAdd(new Cupcake(d.getCakeTopping("Chocolate"), d.getCakeBottom("Vanilla"), 30), 30);
//        shop.cupcakeAdd(new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Vanilla"), 120), 120);
//        shop.cupcakeAdd(new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Chocolate"), 20), 20);
//        shop.cupcakeAdd(cake, 20);
//        u.setCart(shop);
//        System.out.println(u.getBalance());
//        System.out.println("...Before..." + d.updateUserBalance(u));
//        System.out.println("Balance: " + calc.calculatePrice(u));
//        d.updateUserBalance(u);
//        System.out.println("...After..." + d.updateUserBalance(u) + u.getBalance());
//
//        System.out.println("\n\nOrderline here");
//        System.out.println(d.orderID(u));
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
//        System.out.println(u.getBalance());
//        
//        
//        us.setCart(cart);
//        Cupcake cake = new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Chocolate"), 20, 1);
//        us.getCart().cupcakeAdd(cake, 1);
//        System.out.println(us.getCart().shoppingCart.toString());
//        d.updateUserBalance(us);
//        //us.setBalance(us.getBalance() - us.getCart().getTotalPrice());
//        System.out.println(d.getUserBalance(us));
//        
//            System.out.println(d.updateUserBalance(u));
//            System.out.println(u.getBalance());
//            System.out.println(d.getUserBalance(u));

    }
}

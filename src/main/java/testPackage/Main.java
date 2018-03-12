package testPackage;

import calculator.Calculator;
import cupcake.Cupcake;
import databaseConnect.DAO;
import datasource.DataSource1;
import entity.Admin;
import entity.Users;
import shoppingCart.ShoppingCart;

public class Main {

    public static void main(String[] args) {
        DataSource1 ds1 = new DataSource1();
        DAO d = new DAO(ds1.getDataSource());
        Calculator calc = new Calculator();
        Users u = new Users("john", "flaske", 2200, 5);
        Admin ad = new Admin();

//        ad.printUsers();
//        System.out.println(u.getId());
//        u.setId(u);
//        System.out.println(u.getId());
//
//        shop.shoppingCartAdd(new Cupcake(d.getCakeTopping("Chocolate"), d.getCakeBottom("Vanilla"), 30), 30);
//        shop.shoppingCartAdd(new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Vanilla"), 120), 120);
//        shop.shoppingCartAdd(new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Chocolate"), 20), 20);
//        shop.shoppingCartAdd(cake, 20);
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
//        Users us = d.getUser(4);
//        ShoppingCart cart = new ShoppingCart();
//        us.setCart(cart);
//        Cupcake cake = new Cupcake(d.getCakeTopping("Blueberry"), d.getCakeBottom("Chocolate"), 20, 1);
//        us.getCart().shoppingCartAdd(cake, 1);
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

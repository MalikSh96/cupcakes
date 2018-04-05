package entity;

import databaseConnect.DAO;
import datasource.DataSource1;
import shoppingCart.ShoppingCart;

public class Users 
{
    private String username;
    private String password;
    private int id;
    private int balance;
    private boolean admin;
    private String email;
    private ShoppingCart cart;
    DataSource1 ds1 = new DataSource1(); 
    DAO dao = new DAO(ds1.getDataSource());
    
    public Users(String username, int id)
    {
        this.username = username;
        this.id = id;
    }
    
    public Users(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
   
    public Users(String username, String password, String email) 
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Users(String username, String password, boolean admin, String email) 
    {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.email = email;
    }

    public Users(String username, String password, int balance, boolean admin) 
    {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.admin = admin;
    }

    public Users(String username, int id, String password, int balance, boolean admin) 
    {
        this.username = username;
        this.password = password;
        this.id = id;
        this.balance = balance;
        this.admin = admin;
    }
    
    public Users(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
        public Users(String username, String password, int balance, int id) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.id = id;
    }
    

    public Users(int id, int balance) 
    {
        this.id = id;
        this.balance = balance;
    }
    
    public int getId() 
    {
        return id;
    }

    public void setId(Users u) 
    {
       this.id = dao.getUserId(u.getUsername());
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public boolean isAdmin() 
    {
        return admin;
    }

    public void setAdmin(boolean admin) 
    {
        this.admin = admin;
    }

    public int getBalance() 
    {
        return balance;
    }

    public void setBalance(int balance) 
    {
        this.balance = balance;
    }
    
    public ShoppingCart getCart() 
    {
        return cart;
    }

    public void setCart(ShoppingCart cart) 
    {
        this.cart = cart;
    }
    
    @Override
    public String toString() 
    {
        return "\nUser id " + id + "\nUsername: " + username + "\nPassword: " + password + "\nAdmin: " + admin;
    }
}

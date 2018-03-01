package entity;

public class Users 
{
    private String username;
    private String password;
    private int id;
    private int balance;
    private boolean admin;
    private String email;

    
    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }
   

    public Users(String username, String password, boolean admin, String email) {
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

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
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
    
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
    
    @Override
    public String toString() 
    {
        return "User id " + id + "\nUsername: " + username + "\nPassword: " + password + "\nAdmin: " + admin;
    }
}

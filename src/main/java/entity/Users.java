package entity;

public class Users 
{
    private int id;
    private String username;
    private String password;
    private String email;
    private boolean admin;

    public Users(String username, String password, boolean admin) 
    {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public Users(int id, String username, String password, boolean admin) 
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }
    
        public Users(String username, String password, boolean admin, String email) 
    {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() 
    {
        return "User id " + id + "\nUsername: " + username + "\nPassword: " + password + "\nAdmin: " + admin;
    }
}

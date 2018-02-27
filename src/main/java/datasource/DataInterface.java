package datasource;

import cupcake.Cake_bottoms;
import cupcake.Cake_toppings;
import entity.Users;
import java.util.ArrayList;
import java.util.List;

public interface DataInterface 
{
    public ArrayList<Users> getUsers();
    public ArrayList<Users> getUsers(String username);
    public Users getUser(int id);
    public Users getUser(String username);
    public boolean deleteUser(int id);
    public boolean updateUser(Users u);
    public boolean createUser(Users u);
    //public Users validateUser(String username, String password);
    
    public ArrayList<Users> getAdmin(int admin_id);
    public int getBottoms(String bottom_name);
    public int getToppings(String topping_name); 
    public List<Cake_bottoms> getAllBottoms();
    public List<Cake_toppings> getAllToppings();
}

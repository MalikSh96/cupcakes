package databaseConnect;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import connecter.DBConnector;
import cupcake.Cake_bottoms;
import cupcake.Cake_toppings;
import datasource.DataInterface;
import entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

//Change your sql queries, as they for now are wrong

public class DAO implements DataInterface
{
    private DBConnector dbc = new DBConnector();

    public DAO(DataSource ds) 
    {
        dbc.setDs(ds);
    }   

    @Override
    public ArrayList<Users> getUsers() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Users> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from users";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int userid = resultset.getInt("users.user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");

                Users u = new Users(username, userid, userpassword, balance, admin);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public ArrayList<Users> getUsers(String username) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Users> users = new ArrayList();

        try
        {
            dbc.open();

            String sql = "select * from users where username like '%" + username + "%'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int userid = resultset.getInt("users.user_id");
                String name = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");
                
                Users u = new Users(name, userid, userpassword, balance, admin);

                users.add(u);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Users getUser(int id) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Users u = null;
        
        try
        {
            dbc.open();

            String sql = "select * from users where user_id = " + id;
            ResultSet resultset = dbc.executeQuery(sql);

            while(resultset.next())
            {
                int userid = resultset.getInt("user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");
                
                u = new Users(username, userid, userpassword, balance, admin);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public Users getUser(String username) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            dbc.open();

            String sql = "select * from users where username = '" + username + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int userid = resultset.getInt("users.user_id");
                String name = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");
                
                return new Users(name, userid, userpassword, balance, admin);
            }

            dbc.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteUser(int id) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try
        {
            dbc.open();

            String sql = "delete from users where user_id = " + id + ";";
            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateUser(int id, String username)
    {
        try
        {
            dbc.open();

            String sql = "update users set "
                    + "username = '" + username
                    + "' where user_id = " + id;

            System.out.println("ch " + sql);
            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean createUser(Users u) 
    {
        try
        {
            dbc.open();

            String sql = "INSERT into users (username, password, balance, isAdmin) VALUES ("
                    + "'" + u.getUsername() + "',"
                    + "'" + u.getPassword() + "',"
                    + null + ","
                    + u.isAdmin() + ")";
//            System.out.println("ch " + sql);
            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createUserEmail(Users u) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            dbc.open();

            String sql = "insert into user values(null, "
                    + "'" + u.getUsername() + "', "
                    + "'" + u.getPassword() + "', "
                    + "'" + u.getEmail() + "', "
                    + u.isAdmin() + ")";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public List<Cake_bottoms> getAllBottoms() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Cake_toppings ct = new Cake_toppings();
        List<Cake_bottoms> bottoms = new ArrayList<>();
        try 
        {
            dbc.open();

            String sql = "SELECT * FROM cupcakes.bottom";
            ResultSet resultset = dbc.executeQuery(sql);

            while(resultset.next()) 
            {
                String name = resultset.getString("cake_bottom");
                int value = resultset.getInt("price");
                int bt_id = resultset.getInt("id");
                String valuta = resultset.getString("valuta");
                
                Cake_bottoms cake_b = new Cake_bottoms(name, value);
                bottoms.add(cake_b);
               
            }
            dbc.close();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return bottoms;
    }

    @Override
    public List<Cake_toppings> getAllToppings() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Cake_toppings ct = new Cake_toppings();
        List<Cake_toppings> toppings = new ArrayList<>();
        try 
        {
            dbc.open();

            String sql = "SELECT * FROM cupcakes.toppings";
            ResultSet resultset = dbc.executeQuery(sql);

            while(resultset.next()) 
            {
                String name = resultset.getString("cake_topping");
                int value = resultset.getInt("price");
                int tp_id = resultset.getInt("id");
                String valuta = resultset.getString("valuta");
                
                Cake_toppings cake_t = new Cake_toppings(name, value);
                toppings.add(cake_t);
               
            }
            dbc.close();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return toppings;
    }
}

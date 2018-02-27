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

            String sql = "select * from user";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int userid = resultset.getInt("user.user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                Users u = new Users(userid, username, userpassword, admin);

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

            String sql = "select * from user where username like '%" + username + "%'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int userid = resultset.getInt("user.user_id");
                String name = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                Users u = new Users(userid, name, userpassword, admin);

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

            String sql = "select * from user where user_id = " + id;
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int userid = resultset.getInt("user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                u = new Users(userid, username, userpassword, admin);
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

            String sql = "select * from user where username = '" + username + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next())
            {
                int userid = resultset.getInt("user.user_id");
                String name = resultset.getString("username");
                String userpassword = resultset.getString("password");
                boolean admin = resultset.getBoolean("admin");

                return new Users(userid, name, userpassword, admin);
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

            String sql = "delete from team_user where user_id = " + id + ";";
            dbc.executeUpdate(sql);

            sql = "delete from user where user_id = " + id + ";";
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
    public boolean updateUser(Users u)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            dbc.open();

            String sql = "update user set "
                    + "username = '" + u.getUsername() + "', "
                    + "password = '" + u.getPassword() + "', "
                    + "admin = " + u.isAdmin() + " "
                    + "where user_id = " + u.getId();

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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            dbc.open();

            String sql = "insert into user values(null, "
                    + "'" + u.getUsername() + "', "
                    + "'" + u.getPassword() + "', "
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
    
//    @Override
//    public Users validateUser(String username, String password)
//    {
//        Users user = null;
//        
//        try
//        {
//            dbc.open();
//            
//            /*
//            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
//            System.out.println("SQL: " + sql);
//            ResultSet resultSet = dbc.executeQuery(sql);
//            */
//            
//            //PreparedStatement
//            String sql = "select * from user where username = ? and password = ?";
//            PreparedStatement preparedStatement = dbc.preparedStatement(sql); //<-- does not work
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            
//            if (resultSet.next())
//            {
//                int id = resultSet.getInt("user_id");
//                boolean admin = resultSet.getInt("admin") > 0;
//                
//                user = new Users(id, username, password, admin);
//            }
//
//            dbc.close();
//        }
//        catch (SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//        
//        return user;
//    }

    @Override
    public ArrayList<Users> getAdmin(int admin_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getBottoms(String bottom_name) 
    {
        Cake_bottoms cb = new Cake_bottoms();
        int total = 0;
        try 
        {
            dbc.open();

            String sql = "SELECT * FROM cupcakes.bottom";
            ResultSet resultset = dbc.executeQuery(sql);

            while(resultset.next()) 
            {
                String name = resultset.getString("name");
                int value = resultset.getInt("price");
                cb.setBottom(bottom_name);
                cb.setBottom_price(total);
                if(name.equals(bottom_name))
                {
                    cb = new Cake_bottoms(bottom_name, value);
                    total = cb.getBottom_price();
                    break;
                }
            }
            dbc.close();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public int getToppings(String topping_name) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Cake_toppings ct = new Cake_toppings();
        int total = 0;
        try 
        {
            dbc.open();

            String sql = "SELECT * FROM cupcakes.toppings";
            ResultSet resultset = dbc.executeQuery(sql);

            while(resultset.next()) 
            {
                String name = resultset.getString("name");
                int value = resultset.getInt("price");
                ct.setTopping(topping_name);
                ct.setTopping_price(total);
                if(name.equals(topping_name))
                {
                    ct = new Cake_toppings(topping_name, value);
                    total = ct.getTopping_price();
                    break;
                }
            }
            dbc.close();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public List<Cake_bottoms> getAllBottoms() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Cake_bottoms> bottoms = new ArrayList<>();
        
        try
        {
            dbc.open();
            
            String sql = "SELECT * FROM cupcakes.bottom";
            
            
            for(Cake_bottoms bottom : bottoms)
            {
                System.out.println(bottom.getBottom() + "\n");
            }
            

            dbc.executeUpdate(sql);

            dbc.close();
            
            return bottoms;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bottoms;
    }

    @Override
    public List<Cake_toppings> getAllToppings() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

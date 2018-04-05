package databaseConnect;

import connecter.DBConnector;
import cupcake.Cake_bottoms;
import cupcake.Cake_toppings;
import cupcake.Cupcake;
import datasource.DataInterface;
import entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import shoppingCart.ShoppingCart;

/**
 * 
 * @author malik
 * Class contains access to database
 * Implementation of different methods, that access the database
 * Different usage og insert and select, and some set
 * return: Users
 * return: Cake bottoms and toppings
 * return: Booleans
 * return: Order id
 */

//Change your sql queries, as they for now are wrong
public class DAO implements DataInterface {

    private DBConnector dbc = new DBConnector();
    
    
    /**
     * Access to datasource
     * @param ds 
     */
    public DAO(DataSource ds) {
        dbc.setDs(ds);
    }
    
    
    /**
     * Variable users
     * Objective to select from database users' id, name, password, balance and check if is admin.
     * Adds to arraylist of object users
     * @return users
     */
    @Override
    public ArrayList<Users> getUsers() {
        ArrayList<Users> users = new ArrayList();

        try {
            dbc.open();

            String sql = "select * from users";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                int userid = resultset.getInt("users.user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");

                Users u = new Users(username, userid, userpassword, balance, admin);

                users.add(u);
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    /**
     * 
     * @param username
     * Objective is to select from database, and return the user found, by inserting the username
     * @return users found via username from the arraylist
     */
    @Override
    public ArrayList<Users> getUsers(String username) {
        ArrayList<Users> users = new ArrayList();

        try {
            dbc.open();

            String sql = "select * from users where username like '%" + username + "%'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                int userid = resultset.getInt("users.user_id");
                String name = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");

                Users u = new Users(name, userid, userpassword, balance, admin);

                users.add(u);
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * 
     * @param id
     * Objective is to select from database, and return the user found, by inserting the users' id
     * @return 
     */
    @Override
    public Users getUser(int id) {
        Users u = null;

        try {
            dbc.open();

            String sql = "select * from users where user_id = " + id;
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                int userid = resultset.getInt("user_id");
                String username = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");

                u = new Users(username, userid, userpassword, balance, admin);
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    /**
     * 
     * @param username
     * Objective is to select from database, and return the user found, by inserting the username
     * @return the user found by username
     */
    @Override
    public Users getUser(String username) {
        try {
            dbc.open();

            String sql = "select * from users where username = '" + username + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                int userid = resultset.getInt("users.user_id");
                String name = resultset.getString("username");
                String userpassword = resultset.getString("password");
                int balance = resultset.getInt("balance");
                boolean admin = resultset.getBoolean("isAdmin");

                return new Users(name, userid, userpassword, balance, admin);
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 
     * @param id
     * Objective: deleting the user found by using the id
     * @return true if deletion is successful, otherwise false
     */
    @Override
    public boolean deleteUser(int id) {
        try {
            dbc.open();

            String sql = "delete from users where user_id = " + id;
            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    /**
     * 
     * @param username
     * Objective: deleting the user found by username
     * @return true if deletion is successful, otherwise false
     */
    public boolean deleteUser(String username) {
        try {
            dbc.open();

            String sql = "delete from users where username = '" + username + "'";
            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    /**
     * 
     * @param id
     * @param username
     * Objective: Update username by using the id to locate the correct username
     * @return true if update is successful, otherwise false
     */
    @Override
    public boolean updateUser(int id, String username) {
        try {
            dbc.open();

            String sql = "update users set "
                    + "username = '" + username
                    + "' where user_id = " + id;

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 
     * @param u
     * Objective: Create a user in the database, by inserting the username, password, balance, and isAdmin
     * @return true if creation is successful, otherwise false
     */
    @Override
    public boolean createUser(Users u) {
        try {
            dbc.open();

            String sql = "INSERT into users (username, password, balance, isAdmin) VALUES ("
                    + "'" + u.getUsername() + "',"
                    + "'" + u.getPassword() + "',"
                    + "'" + u.getBalance() + "',"
                    + u.isAdmin() + ")";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 
     * @param cake
     * Objective: To search the database and find the cake bottom using a string
     * Excpects a return of object cake_bottoms
     * @return a new instance of a cake bottom with its id and price
     */
    @Override
    public Cake_bottoms getCakeBottom(String cake) {
        try {
            dbc.open();

            String sql = "select * from bottom where cake_bottom = '" + cake + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                String bottom_name = resultset.getString("cake_bottom");
                int price = resultset.getInt("price");
                int id = resultset.getInt("id");

                return new Cake_bottoms(bottom_name, price, id);
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 
     * @param cake
     * Objective: To search the database and find the cake topping using a string 
     * Excpects a return of object cake_toppings
     * @return a new instance of a cake topping with its id and price 
     */
    @Override
    public Cake_toppings getCakeTopping(String cake) {
        try {
            dbc.open();

            String sql = "select * from toppings where cake_topping = '" + cake + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                String topping_name = resultset.getString("cake_topping");
                int price = resultset.getInt("price");
                int id = resultset.getInt("id");

                return new Cake_toppings(topping_name, price, id);
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Objective: search the database for all bottoms
     * @return 
     * @returns a list of all the bottoms available 
     */
    @Override
    public List<Cake_bottoms> getAllBottoms() {
        List<Cake_bottoms> bottoms = new ArrayList<>();
        try {
            dbc.open();

            String sql = "SELECT * FROM cupcakes.bottom";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                String name = resultset.getString("cake_bottom");
                int value = resultset.getInt("price");
                int bt_id = resultset.getInt("id");
                String valuta = resultset.getString("valuta");

                Cake_bottoms cake_b = new Cake_bottoms(name, value, bt_id);
                bottoms.add(cake_b);

            }
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bottoms;
    }

    /**
     * Objective: search the database for all toppings
     * @return 
     * @returns a list of all the toppings available 
     */
    @Override
    public List<Cake_toppings> getAllToppings() {
        List<Cake_toppings> toppings = new ArrayList<>();
        try {
            dbc.open();

            String sql = "SELECT * FROM cupcakes.toppings";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                String name = resultset.getString("cake_topping");
                int value = resultset.getInt("price");
                int tp_id = resultset.getInt("id");
                String valuta = resultset.getString("valuta");

                Cake_toppings cake_t = new Cake_toppings(name, value, tp_id);
                toppings.add(cake_t);

            }
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toppings;
    }

    /**
     * 
     * @param cake
     * Objective: Search the database to get the price, using the name, price and id
     * New instance of cake bottom, if name searched equals the wanted, the bottom variable is overwritten
     * @return total (total is the price)
     */
    @Override
    public int getCakeBottomPrice(String cake) {
        Cake_bottoms bottom = new Cake_bottoms();
        int total = 0;
        try {
            dbc.open();

            String sql = "SELECT * FROM bottom";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                String name = resultset.getString("cake_bottom");
                int value = resultset.getInt("price");
                int id = resultset.getInt("id");
                bottom.setBottom(name);
                bottom.setBottom_price(value);
                if (name.equals(cake)) {
                    bottom = new Cake_bottoms(cake, value, id);
                    total = bottom.getBottom_price();
                    break;
                }
            }
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    
    /**
     * 
     * @param cake
     * Objective: Search the database to get the price, using the name, price and id
     * New instance of cake topping, if name searched equals the wanted, the topping variable is overwritten
     * @return total
     */
    @Override
    public int getCakeToppingPrice(String cake) {
        Cake_toppings topping = new Cake_toppings();
        int total = 0;
        try {
            dbc.open();

            String sql = "SELECT * FROM toppings";
            //String sql = "SELECT * FROM toppings where cake_topping = '" + cake + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                String name = resultset.getString("cake_topping");
                int value = resultset.getInt("price");
                int id = resultset.getInt("id");
                topping.setTopping(name);
                topping.setTopping_price(value);
                if (name.equals(cake)) {
                    topping = new Cake_toppings(cake, value, id);
                    total = topping.getTopping_price();
                    break;
                }
            }
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 
     * @param u
     * Objective: Find the balance of the user from the database
     * @return userbalance
     */
    public int getUserBalance(Users u) {
        int balance;
        try {
            dbc.open();

            String sql = "select * from users where user_id = '" + u.getId()
                    + "'";
            ResultSet resultset = dbc.executeQuery(sql);
            while(resultset.next()) {
                balance = resultset.getInt("balance");
                return balance;
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 
     * @param username
     * Objective: Find the user id, using the username to locate it
     * @return id
     */
    public int getUserId(String username) {
        try {
            dbc.open();

            String sql = "select * from users where username = '" + username + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                int id = resultset.getInt("user_id");
                return id;
            }

            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 
     * @param u
     * Objective: Update the users' balance in the database, after confirmation of order
     * @return true if balance is updated, else false
     */
    public boolean updateUserBalance(Users u) {

        int currentBalance = getUserBalance(u);
        int balance = currentBalance - u.getCart().getTotalPrice();
//        System.out.println("Balance after shopping " +balance);
//        System.out.println("Current balance " + currentBalance);
//        System.out.println("Cart total price " + u.getCart().getTotalPrice());
//        System.out.println("user id " + u.getId());
        try {
            dbc.open();

            String sql = "update users set "
                    + "balance = '" + balance
                    + "' where user_id = " + u.getId();

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 
     * @param u
     * Objective: Create an order id to the users' order, inserts into the database the id created
     * @return id
     */
    public Users orderID(Users u) {
        int orderId = 0;
        try {
            dbc.open();
            String sql = "insert into orders(userOrderID) values (?)";
            PreparedStatement prep = dbc.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS);

            prep.setInt(1, u.getId()); //user id
            dbc.getConnection().setAutoCommit(false);

            System.out.println("Check sql orderID: " + sql);
            int check = prep.executeUpdate();
            if (check == 1) {
                ResultSet res = prep.getGeneratedKeys();
                res.next();
                orderId = res.getInt(1); //ir
                System.out.println("DEBUG : " + orderId);

                OrderLine(u.getCart(), orderId);
                u.getCart().setId(orderId);
                dbc.getConnection().commit();
            } else {
                dbc.getConnection().rollback();
            }

            dbc.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    /**
     * 
     * @param cart
     * @param orderId
     * Objective: Create and orderline by inserting the id'sof the toppings and bottoms chosen, quantity and the order id chosen to it
     * @return true if an orderline is created
     */
    public boolean OrderLine(ShoppingCart cart, int orderId) {
        ArrayList<Cupcake> cupcakes = cart.getShoppingCart();

        try {
            dbc.open();
            for (int i = 0; i < cupcakes.size(); i++) {
                String sql = "insert into orderline(toppings_id, bottom_id, qty, orders_id) values (?,?,?,?);";
                PreparedStatement prep = dbc.preparedStatement(sql);

                prep.setInt(1, cupcakes.get(i).getTopping().getId());
                prep.setInt(2, cupcakes.get(i).getBottom().getId());
                prep.setInt(3, cupcakes.get(i).getAmount()); //
                prep.setInt(4, orderId);

                System.out.println("Check sql: " + sql);
                prep.executeUpdate();
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Note: needs more explanation
     * @param username
     * @param password
     * @return 
     */
    public Users validateUser(String username, String password) {
        Users user = null;

        try {
            dbc.open();

            String sql = "select * from users where username = ? and password = ?";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int balance = resultSet.getInt("balance");
                // boolean admin = resultSet.getInt("admin") > 0;

                user = new Users(username, password, balance);
            }

            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    /**
     * Note: Maybe needs more explanation
     * @param cake_top
     * @param cake_bottom
     * @param amount
     * @return cupcake created
     */
    public Cupcake getCake(String cake_top, String cake_bottom, int amount) {

        Cake_toppings top = null;
        Cake_bottoms bottom = null;
        int price = 0;
        try {
            dbc.open();

            String sql = "select * from toppings where cake_topping = '" + cake_top + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
                String topping_name = resultset.getString("cake_topping");
                int topPrice = resultset.getInt("price");
                int id = resultset.getInt("id");

                top = new Cake_toppings(topping_name, topPrice, id);
                price += topPrice;
            }

            String sql2 = "select * from bottom where cake_bottom = '" + cake_bottom + "'";
            ResultSet resultset2 = dbc.executeQuery(sql2);

            while (resultset2.next()) {
                String bottom_name = resultset.getString("cake_bottom");
                int bottomPrice = resultset.getInt("price");
                int id = resultset.getInt("id");
                price += bottomPrice;
                bottom = new Cake_bottoms(bottom_name, bottomPrice, id);
            }

            dbc.close();
            return new Cupcake(top, bottom, price, amount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Note: Needs more explanation
     * @param u
     * @return true if isAdmin 
     */
    public boolean validateAdmin(Users u) {
        
        try {
            dbc.open();

            String sql = "select * from users where username = '" + u.getUsername() + "'";
            ResultSet resultset = dbc.executeQuery(sql);

            while (resultset.next()) {
               int id = resultset.getInt("isAdmin");
               if(id == 1) {
                   u.setAdmin(true);
                   return true;
               }
            }
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

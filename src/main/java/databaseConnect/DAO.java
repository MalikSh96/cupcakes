package databaseConnect;

import calculator.Calculator;
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

//Change your sql queries, as they for now are wrong
public class DAO implements DataInterface {

    private DBConnector dbc = new DBConnector();

    public DAO(DataSource ds) {
        dbc.setDs(ds);
    }

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

    public boolean createUserEmail(Users u) {
        try {
            dbc.open();

            String sql = "insert into user values(null, "
                    + "'" + u.getUsername() + "', "
                    + "'" + u.getPassword() + "', "
                    + "'" + u.getEmail() + "', "
                    + u.isAdmin() + ")";

            dbc.executeUpdate(sql);

            dbc.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

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

    public int getUserBalance(Users u) {
        int balance = u.getBalance();
        try {
            dbc.open();

            String sql = "select * from users where username = '" + u.getUsername()
                    + "'";

            dbc.executeQuery(sql);

            dbc.close();

            return balance;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }

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

    public boolean updateUserBalance(Users u) {

        int balance = u.getBalance() - u.getCart().getTotalPrice();
        System.out.println(balance);
        System.out.println(u.getCart().getTotalPrice());
        System.out.println(u.getId());
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

package usersearch;

import connecter.DBConnector;
import databaseConnect.DAO;
import datasource.DataSource1;
import entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Searcher {

    private DBConnector dbc = new DBConnector();

    public Searcher(DataSource ds) {
        dbc.setDs(ds);
    }

    private DataSource1 ds = new DataSource1();
    private DAO dao = new DAO(ds.getDataSource());

    private String username;
    private String password;

    public Searcher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users getUsername(String username, String password) {

        Users user = null;
        
        try
        {
            dbc.open();
            

            String sql = "select * from user";
            PreparedStatement preparedStatement = dbc.preparedStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.getResultSet();
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next())
            {
                int id = resultSet.getInt("user_id");
                
                
                user = new Users(username, password);
            }

            dbc.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return user;
    }
        


    public boolean getPassword(String username, String password) {
        if (dao.getUser(username).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean alreadyExist(String username) {
        if (dao.getUser(username) != null) {
            System.out.println("User already exist");
            return true;
        } else {
            return false;
        }
    }
}
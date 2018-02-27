package connecter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

//For database connecting, original version...
public class DBConnector 
{   
    private DataSource ds;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet; 
    
    public DBConnector() 
    {
        
    }
    
    public DBConnector(DataSource ds) 
    {
        this.ds = ds;
    }

    public void setDs(DataSource ds) 
    {
        this.ds = ds;
    }
    
    public Connection getConnection()
    {
        return connection;
    }
    
    public void open() throws SQLException
    {
        if(connection == null || connection.isClosed())
        {
            connection = ds.getConnection();
        }
    }
    
    public void close() throws SQLException
    {
        if(resultSet != null)
        {
            resultSet.close();
        }
        
        if(statement != null)
        {
            statement.close();
        }
        
        if(connection != null && !connection.isClosed())
        {
            connection.close();
            connection = null;
        }
    }
    
    public ResultSet executeQuery(String sql) throws SQLException
    {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        
        return resultSet;
    }
    
    public void executeUpdate(String sql) throws SQLException
    {
        statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}

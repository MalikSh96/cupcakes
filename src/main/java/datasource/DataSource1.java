package datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource1 
{
    MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSource1()
    {
        dataSource.setServerName("your ip/localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("cupcakes");     
        dataSource.setUser("maliksh");
        dataSource.setPassword("your password");       
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}

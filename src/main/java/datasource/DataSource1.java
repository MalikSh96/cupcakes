package datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource1 
{
    MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSource1()
    {
        dataSource.setServerName("aaa");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("cupcakes");     
        dataSource.setUser("maliksh");
        dataSource.setPassword("ooo");       
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}

package datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource1 
{
    MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSource1()
    {
        dataSource.setServerName("159.89.10.5");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("cupcakes");     
        dataSource.setUser("maliksh");
        dataSource.setPassword("FCBarcelona4ever#");       
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}

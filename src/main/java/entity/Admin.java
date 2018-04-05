package entity;

import databaseConnect.UsersOrders;
import datasource.DataSource1;
import java.util.ArrayList;

public class Admin {
    
    
    DataSource1 ds1 = new DataSource1();
    UsersOrders dao = new UsersOrders(ds1.getDataSource());   
    
    ArrayList<Users> users = dao.getUsers();
    public ArrayList<String> usernames = new ArrayList();
    public void printUsers() {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }
    
    public void nameList() {
        for (int i = 0; i < users.size(); i++) {
            usernames.add(users.get(i).getUsername()+"<br>");
        }
    }

}

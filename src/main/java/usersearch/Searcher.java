package usersearch;

import databaseConnect.DAO;
import datasource.DataSource1;

public class Searcher {

    private DataSource1 ds = new DataSource1();
    private DAO dao = new DAO(ds.getDataSource());

    private String username;
    private String password;

    public Searcher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void getUsername(String username, String password) {
        if (dao.getUser(username) == null) {
            System.out.println("user not found :(");
        } else {
            getPassword(username, password);
        }
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
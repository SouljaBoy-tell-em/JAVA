import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	private final static String SQL_ID = "jdbc:mysql://127.0.0.1:3306/mydb";
	private final static String ROOT = "root";
	private final static String PASSWORD = "1543";
	private final static String DB_NAME = "students";
	private final static String DELETE_STRING = "DELETE FROM " + DB_NAME + " WHERE ID = ";
	private final static String INSERT_STRING = "INSERT INTO " + DB_NAME + " VALUES(";
	private final static String UPDATE_STRING = "UPDATE " + DB_NAME + " SET name='";
	
	private static Connection connection;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    	// DriverManager.getConnetion("адрес базы данных", "корневой элемент(def:root), "пароль");
        connection = DriverManager.getConnection(SQL_ID, ROOT, PASSWORD);
        
        //delete(/* your id */); 
        //insert(/* your id */, /* "your name" */);
        //update(/* your id */, /* "new name" */);
        
        connection.close();
        System.out.println("Connection has been closed.");
    }
    
    private static void delete(int id) throws SQLException {
		
		Statement statement = connection.createStatement();
		statement.execute(DELETE_STRING + id);
	}

	private static void insert(int id, String name) throws SQLException {

		Statement statement = connection.createStatement();
		statement.execute(INSERT_STRING + id + ", '" + name + "')");
	}
	
	private static void update(int id, String name) throws SQLException { 
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(UPDATE_STRING + name + "' WHERE id = " + id);
	}
}


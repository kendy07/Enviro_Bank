package envirobank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author
 */
public class CurrentAccountDA {

    public static ArrayList<CurrentAccount> arAccounts = new ArrayList<>();
    public static ArrayList<Integer> arNumbers = new ArrayList<>();
    
    public CurrentAccount objAccount;

    private static Connection UserConn;
    private static PreparedStatement pStatement;
    private static ResultSet results;

    
    public static void initConnection() throws DataStorageException {
        final String USERNAME = "root";
        final String PASSWORD = "";
        final String URL = "jdbc:mysql://localhost/SystemDB";
        final String DRIVER = "com.mysql.jdbc.Driver";

        try {
            //Driver registration
            Class.forName(DRIVER);
            //creating connection
            UserConn = DriverManager.getConnection(USERNAME, PASSWORD, URL);

        } catch (ClassNotFoundException e) {
            //driver exception
            throw new DataStorageException("Database Driver not found.\n" + e.getMessage());

        } catch (SQLException e) {
            throw new DataStorageException("Connection Failed\n" + e.getMessage());

        }

    }

    //2
    public static void terminate() throws DataStorageException {
        try {
            if (UserConn != null) {
                UserConn.close();
            }
        } catch (SQLException e) {
            throw new DataStorageException(e.getMessage());
        }
    }
    
    public static void withDraw(int accNum,  Double minusAmnt) throws NotFoundException, SQLException {

        String withdrawQuery = "UPDATE currentAccount SET acc_Bal - " + minusAmnt + " WHERE acc_no = " + accNum + 
                " AND acc_balance + 100000 > " + minusAmnt + " AND " + minusAmnt + " <= acc_Bal" ;

        try {
            pStatement = UserConn.prepareStatement(withdrawQuery);
            results = pStatement.executeQuery();

        } catch (SQLException e) {
            results = pStatement.getGeneratedKeys();
            throw new NotFoundException("Acc number: " + results.getInt(1) + " was not found" + e.getMessage());
        }

    }

}
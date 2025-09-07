package EMP;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    private static Connection con = null;

    private DBconnection() {}
 
    static {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EMP", // DB URL
                    "root",  // username
                    "Manoj"   // password
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }
}

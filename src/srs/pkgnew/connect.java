package srs.pkgnew;

import java.sql.*;

public class connect {

    private static Connection connection = null;

    static {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\user\\Desktop\\test\\Database1.accdb", "", "");
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

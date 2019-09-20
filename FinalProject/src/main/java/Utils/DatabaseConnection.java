package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    public List<String> connectToDB(String dbURL, String user, String pass, String sql) throws SQLException {

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
//
//        String dbURL = "jdbc:mysql://bhdtest.endava.com:3306/petclinic";
//        String user = "root";
//        String pass = "root";
        List<String> namesOfOwner = new ArrayList<String>();

        try {
            conn = DriverManager.getConnection(dbURL, user, pass);
            statement = conn.createStatement();
            //String sql = "select * from owners";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                namesOfOwner.add(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return namesOfOwner;
    }
}

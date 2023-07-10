package demo;

import java.sql.*;

public class demo {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        System.out.println("hello");

        // DB Connection
        String url = "jdbc:mysql://localhost:3306/flight";
        String uName = "root";
        String pWord = "root";
        Connection con = DriverManager.getConnection(url, uName, pWord);

        Statement st = con.createStatement();

        // CREATE operation
        String insertQuery = "INSERT INTO flights (name) VALUES ('flight1')";
        int rowsInserted = st.executeUpdate(insertQuery);

        if (rowsInserted > 0) {
            System.out.println("Flight inserted successfully");

            // READ operation
            String selectQuery = "SELECT * FROM flights";
            ResultSet rs = st.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println("Id is " + rs.getInt(1));
                System.out.println("Name is " + rs.getString(2));
            }

            // UPDATE operation
            String updateQuery = "UPDATE flights SET name = 'updated_flight' WHERE id = 1";
            int rowsUpdated = st.executeUpdate(updateQuery);

            if (rowsUpdated > 0) {
                System.out.println("Flight updated successfully");
            } else {
                System.out.println("Something went wrong while updating");
            }

            // DELETE operation
            String deleteQuery = "DELETE FROM flights WHERE id = 1";
            int rowsDeleted = st.executeUpdate(deleteQuery);

            if (rowsDeleted > 0) {
                System.out.println("Flight deleted successfully");
            } else {
                System.out.println("Something went wrong while deleting");
            }
        } else {
            System.out.println("Something went wrong while inserting");
        }
    }
}

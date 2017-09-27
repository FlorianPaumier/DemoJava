package com.tactfactory.demo1.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {

    public static void run() {

        try {
            // Load JDBC driver !
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK !");

            // Connect to Database.
            String cnxString = "jdbc:mysql://localhost:3306/toto";
            String dbLogin   = "root";
            String dbPass    = "toor";

            Connection conn = DriverManager.getConnection(cnxString, dbLogin, dbPass);
            conn.setAutoCommit(false); // Disable for manual Transaction
            System.out.println("Connection OK !");

            String query = "SELECT * FROM MaTable WHERE id=?"; // AND name=?";
            //                                     index    1               2

            // Without security
//            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // With security
            PreparedStatement prepare = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            prepare.setInt(1, 1);
//            prepare.setString(2, "Mickael");

//            ResultSet result = state.executeQuery(query);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                result.updateString("name", "Micka");
                result.updateRow();
                System.out.println(name);
            }

            conn.commit();

            query = "INSERT INTO MaTable VALUES (null, 'TotoLand', 20)";
            prepare = conn.prepareStatement(query);
            prepare.executeUpdate();

            conn.commit();

            result.close();
            prepare.close();
//            state.close();

            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("bye..");

    }

}

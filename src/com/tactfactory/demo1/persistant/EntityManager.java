package com.tactfactory.demo1.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityManager {

    private static EntityManager singleton;

    String cnxString = "jdbc:mysql://localhost:3306/calculator";
    String dbLogin   = "root";
    String dbPass    = "toor";

    Connection conn = null;

    private EntityManager() {

        // Load JDBC driver !
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK !");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver KO !");
            e.printStackTrace();
        }

        // Connect to Database.
        try {
            this.conn = DriverManager.getConnection(cnxString, dbLogin, dbPass);
            System.out.println("Connection OK !");
        } catch (SQLException e) {
            System.out.println("Connection KO !");
            e.printStackTrace();
        }

    }

    public static EntityManager getInstance() {
        if (singleton == null) {
            singleton = new EntityManager();
        }

        return singleton;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public HistoryRepository getHistoryRepository() {
        return new HistoryRepository(this);
    }

}

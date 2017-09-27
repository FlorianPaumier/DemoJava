package com.tactfactory.demo1.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database manager
 * @author Mickael Gaillard <mickael.gaillard@tactfactory.com>
 * @version 1.0
 */
public class EntityManager {

    // Design Pattern : SINGLETON
    private static final EntityManager singleton = new EntityManager();
    public static EntityManager getInstance() {
        return singleton;
    }

    private String cnxString = "jdbc:mysql://localhost:3306/calculator";
    private String dbLogin   = "root";
    private String dbPass    = "toor";

    private Connection conn = null;

    /** Hidden Constructor. */
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

    public Connection getConnection() {
        return this.conn;
    }

    public HistoryRepository getHistoryRepository() {
        return new HistoryRepository(this);
    }

    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

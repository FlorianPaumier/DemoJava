package com.tactfactory.demo1.persistant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tactfactory.demo1.calculator.BaseCommand;
import com.tactfactory.demo1.calculator.Command;

public class HistoryRepository {

    private static final String TABLE = "command";

    private final EntityManager manager;

    public HistoryRepository(EntityManager entityManager) {
        this.manager = entityManager;
    }

    public void persist(Command command) {
        Statement state = null;
        BaseCommand baseComm = (BaseCommand) command;
        String query = String.format("INSERT INTO " + TABLE + " VALUES (null, '%s')", baseComm.getResult());

        try {
            state = this.manager.getConnection().createStatement();
            state.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteAll() {
        String query = "DELETE FROM " + TABLE + ";";
        Statement state = null;
        try {
            state = this.manager.getConnection().createStatement();
            state.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<String> getAll() {
        List<String> result = new ArrayList<>();
        Statement state = null;

        try {
            state = this.manager.getConnection().createStatement();
            ResultSet resultSet = state.executeQuery("SELECT * FROM " + TABLE + ";");

            while (resultSet.next()) {
                String value = resultSet.getString("value");
                result.add(value);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}

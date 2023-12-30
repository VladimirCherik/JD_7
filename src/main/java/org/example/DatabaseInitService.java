package org.example;


import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInitService {
    public static void main(String[] args){

        SqlFileReader reader = new SqlFileReader();

        try (Statement stmt = Database.getInstance().getConnection().createStatement()) {
            stmt.execute(reader.sqlQueryFromFileReader("init_db.sql"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

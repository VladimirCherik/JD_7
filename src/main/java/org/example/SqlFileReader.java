package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SqlFileReader {
    public String sqlQueryFromFileReader(String filePath) {
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("sql/" + filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sqlQuery.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlQuery.toString();
    }
}

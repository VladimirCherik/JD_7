package org.example;

import org.example.TypeToGetResponse.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    SqlFileReader reader = new SqlFileReader();
    private Statement stmt;



    public DatabaseQueryService() {
        try {
            stmt = Database.getInstance().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        List<YoungestEldestWorkers> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_youngest_eldest_workers.sql"));
        while(rs.next()) {
            list.add(new YoungestEldestWorkers(
                    rs.getString("type"),
                    rs.getString("name"),
                    LocalDate.parse(rs.getString("birthday")))
            );
        }
        return list;
    }
    public List<MaxSalaryWorker>  findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryWorker> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_max_salary_worker.sql"));
        while(rs.next()) {
            list.add(new MaxSalaryWorker( rs.getString("name"),
                    rs.getInt("salary")));
        }
        return list;
    }
    public List<MaxProjectsClient>  findMaxProjectsClient() throws SQLException {
        List<MaxProjectsClient> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_max_projects_client.sql"));
        while(rs.next()) {
            list.add(new MaxProjectsClient( rs.getString("name"),
                    rs.getInt("project_count")));
        }
        return list;
    }
    public List<LongestProject>  findLongestProject() throws SQLException {
        List<LongestProject> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("find_longest_project.sql"));
        while(rs.next()) {
            list.add(new LongestProject( rs.getString("project_id"),
                    rs.getInt("month_count")));
        }
        return list;
    }
    public List<ProjectPrices>  findProjectPrices() throws SQLException {
        List<ProjectPrices> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(reader.sqlQueryFromFileReader("print_project_prices.sql"));

        while(rs.next()) {
            list.add(new ProjectPrices( rs.getInt("project_id"),
                    rs.getInt("prise")));
        }
        return list;
    }
}

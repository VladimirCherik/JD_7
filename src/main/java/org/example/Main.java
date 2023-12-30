package org.example;

import org.example.TypeToGetResponse.*;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseQueryService queryService = new DatabaseQueryService();

        System.out.println("\nYoungestEldestWorkers----------");
        for (YoungestEldestWorkers res: queryService.findYoungestEldestWorkers()) {
            System.out.println(res.getType()+ " " + res.getName() + " " + res.getBirthday());
        }

        System.out.println("\nMaxSalaryWorker------------");
        for (MaxSalaryWorker res: queryService.findMaxSalaryWorker()) {
            System.out.println(res.getName() + " " + res.getSalary());
        }

        System.out.println("\nMaxProjectsClient---------");
        for (MaxProjectsClient res: queryService.findMaxProjectsClient()) {
            System.out.println(res.getName() + " " + res.getProjectCount());
        }

        System.out.println("\nLongestProject-----------");
        for (LongestProject res: queryService.findLongestProject()) {
            System.out.println("project_id " + res.getName() + " - " + res.getMonthCount() + " months");
        }

        System.out.println("\nProjectPrices-----------");
        for (ProjectPrices res: queryService.findProjectPrices()) {
            System.out.println("project_id " + res.getName() + " - " + res.getPrice());
        }



    }
}
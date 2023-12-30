package org.example;

import org.example.TypeToMakeInsert.ClientInsert;
import org.example.TypeToMakeInsert.ProjectInsert;
import org.example.TypeToMakeInsert.ProjectWorkerInsert;
import org.example.TypeToMakeInsert.WorkerInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    private static Connection connection = Database.getInstance().getConnection();
    private static final String SQL_WORKER_TO_POPULATE =
            "INSERT INTO worker (name, birthday, level, salary) VALUES (?,?,?,?)";
    private static final String SQL_CLIENT_TO_POPULATE = "INSERT INTO client (name) VALUES (?)";
    private static final String SQL_PROJECT_TO_POPULATE =
            "INSERT INTO project (client_id, start_date, finish_date) VALUES ( ?, ?, ?)";
    private static final String SQL_PROJECT_WORKER_TO_POPULATE =
            "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES ( ?, ?)";



    public static void main(String[] args) throws SQLException {

        //First Batch
        PreparedStatement prSt = connection.prepareStatement(SQL_WORKER_TO_POPULATE);
        for (WorkerInsert worker : getListWorkersData()) {
            prSt.setString(1, worker.getName());
            prSt.setString(2, worker.getBirthday());
            prSt.setString(3, worker.getLevel());
            prSt.setInt(4, worker.getSalary());
            prSt.addBatch();
        }
        prSt.executeBatch();


        //Second Batch
        prSt = connection.prepareStatement(SQL_CLIENT_TO_POPULATE);
        for (ClientInsert client : getListClientsData()) {
            prSt.setString(1, client.getName());
            prSt.addBatch();
        }
        prSt.executeBatch();


        // Third Batch
        prSt = connection.prepareStatement(SQL_PROJECT_TO_POPULATE);
        for(ProjectInsert project : getListProjectData()){
            prSt.setInt(1, project.getClientId());
            prSt.setString(2, project.getStartDate());
            prSt.setString(3, project.getFinishDate());
            prSt.addBatch();
        }
        prSt.executeBatch();

        //Fourth Batch
        prSt = connection.prepareStatement(SQL_PROJECT_WORKER_TO_POPULATE);
        for(ProjectWorkerInsert pW : getListProjectWorkerData()){
            prSt.setInt(1, pW.getProjectId());
            prSt.setInt(2, pW.getWorkerId());
            prSt.addBatch();
        }
        prSt.executeBatch();

    }

    private static List<ProjectWorkerInsert> getListProjectWorkerData() {

        List<ProjectWorkerInsert> projectWorkerInserts = new ArrayList<>();
        projectWorkerInserts.add(new ProjectWorkerInsert(1, 1));
        projectWorkerInserts.add(new ProjectWorkerInsert(2, 2));
        projectWorkerInserts.add(new ProjectWorkerInsert(3, 3));
        projectWorkerInserts.add(new ProjectWorkerInsert(4, 4));
        projectWorkerInserts.add(new ProjectWorkerInsert(5, 2));
        projectWorkerInserts.add(new ProjectWorkerInsert(6, 3));
        projectWorkerInserts.add(new ProjectWorkerInsert(7, 4));
        projectWorkerInserts.add(new ProjectWorkerInsert(8, 5));
        projectWorkerInserts.add(new ProjectWorkerInsert(9, 4));
        projectWorkerInserts.add(new ProjectWorkerInsert(10, 6));
        projectWorkerInserts.add(new ProjectWorkerInsert(10, 7));
        projectWorkerInserts.add(new ProjectWorkerInsert(10, 8));
        projectWorkerInserts.add(new ProjectWorkerInsert(10, 9));
        projectWorkerInserts.add(new ProjectWorkerInsert(10, 10));
        return projectWorkerInserts;
    }

    private static List<ProjectInsert> getListProjectData() {
        List<ProjectInsert> projectInserts = new ArrayList<>();
        projectInserts.add(new ProjectInsert(1, "2020-01-01", "2020-02-01"));
        projectInserts.add(new ProjectInsert(1, "2021-01-01", "2022-01-01"));
        projectInserts.add(new ProjectInsert(1, "2020-05-01", "2020-07-01"));
        projectInserts.add(new ProjectInsert(2, "2020-06-01", "2020-08-01"));
        projectInserts.add(new ProjectInsert(3, "2020-11-01", "2020-12-01"));
        projectInserts.add(new ProjectInsert(3, "2012-01-01", "2020-03-01"));
        projectInserts.add(new ProjectInsert(4, "2017-01-01", "2020-01-01"));
        projectInserts.add(new ProjectInsert(4, "2016-01-01", "2020-06-01"));
        projectInserts.add(new ProjectInsert(5, "2017-01-01", "2020-09-01"));
        projectInserts.add(new ProjectInsert(5, "2015-01-01", "2023-03-01"));
        return projectInserts;
    }

    private static List<WorkerInsert> getListWorkersData() {
        List<WorkerInsert> workerInserts = new ArrayList<>();
        workerInserts.add(new WorkerInsert("John",   "1970-12-11", "Senior", 6000));
        workerInserts.add(new WorkerInsert("Rob",   "1988-11-13", "Middle", 2000));
        workerInserts.add(new WorkerInsert("Andrey",   "1986-10-14", "Trainee", 500));
        workerInserts.add(new WorkerInsert("Julia",   "1981-09-15", "Middle", 4000));
        workerInserts.add(new WorkerInsert("Ann",   "1985-08-16", "Middle", 2000));
        workerInserts.add(new WorkerInsert("Simon",   "1965-12-17", "Middle", 3000));
        workerInserts.add(new WorkerInsert("Chick",   "1997-10-18", "Junior", 1000));
        workerInserts.add(new WorkerInsert("Peter",   "1991-11-19", "Middle", 3000));
        workerInserts.add(new WorkerInsert("Arnold",   "1987-01-20", "Junior", 1500));
        workerInserts.add(new WorkerInsert("Eugene",   "1981-12-11", "Senior", 7000));
        return workerInserts;
    }

    private static List<ClientInsert> getListClientsData(){
        List<ClientInsert> clientInserts = new ArrayList<>();
        clientInserts.add(new ClientInsert("Jack"));
        clientInserts.add(new ClientInsert("Alex"));
        clientInserts.add(new ClientInsert("Den"));
        clientInserts.add(new ClientInsert("Martin"));
        clientInserts.add(new ClientInsert("Abraham"));
        return clientInserts;
    }
}

package org.example.TypeToMakeInsert;

public class ProjectWorkerInsert {
    private int  projectId;
    private int workerId;

    public int getProjectId() {
        return projectId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public ProjectWorkerInsert(int projectId, int workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }
}

package org.example.TypeToMakeInsert;

public class ProjectInsert {
    private int clientId;
    private String startDate;
    private String finishDate;

    public int getClientId() {
        return clientId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public ProjectInsert(int clientId, String startDate, String finishDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}

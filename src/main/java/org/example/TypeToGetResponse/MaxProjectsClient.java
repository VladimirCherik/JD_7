package org.example.TypeToGetResponse;

public class MaxProjectsClient {
    private final String name;
    private final int projectCount;
    public MaxProjectsClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return projectCount;
    }
}

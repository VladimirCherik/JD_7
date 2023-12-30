package org.example.TypeToGetResponse;

public class LongestProject {
    private final String name;
    private final int monthCount;
    public LongestProject(String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    public String getName() {
        return name;
    }

    public int getMonthCount() {
        return monthCount;
    }
}

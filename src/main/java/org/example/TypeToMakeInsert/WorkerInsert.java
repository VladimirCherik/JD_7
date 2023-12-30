package org.example.TypeToMakeInsert;

public class WorkerInsert {
    private String name;
    private String birthday;
    private String level;
    private int salary;

    public String getName() {
        return name;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getLevel() {
        return level;
    }
    public int getSalary() {
        return salary;
    }
    public WorkerInsert(String name, String birthday, String level, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }
}

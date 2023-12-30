package org.example.TypeToGetResponse;

import java.time.LocalDate;

public class YoungestEldestWorkers {
    private final String type;
    private final String name;
    private final LocalDate birthday;
    public YoungestEldestWorkers(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}

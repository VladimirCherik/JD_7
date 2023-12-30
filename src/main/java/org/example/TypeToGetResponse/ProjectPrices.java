package org.example.TypeToGetResponse;

public class ProjectPrices {
    private final int name;
    private final int price;
    public ProjectPrices(int name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

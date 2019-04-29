package model;

public class Currency {
    private String name;
    private Double rate;

    public Currency() {
    }

    public Currency(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}

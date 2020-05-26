package oop.model;

import model.ServiceTypes;

public class Service implements Cloneable {

    private String name;
    private double cost;
    private ServiceTypes type;

    public Service() {
        name = "интернет 100мб\\сек";
        cost = 300;
        type = ServiceTypes.INTERNET;
    }

    public Service(String name, double cost, ServiceTypes type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public ServiceTypes getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(cost) * name.hashCode() * type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Service service = (Service) obj;
            return cost == service.cost
                    && type == service.type
                    && name.equals(service.name);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%.40s \\\\%.2fp.", name, cost); //“<name (40 символов)>\\<cost>р.”
    }

    @Override
    public Service clone() throws CloneNotSupportedException {
        return new Service(name, cost, type);
    }

}

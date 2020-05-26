package oop.model;

import model.ServiceTypes;
import model.Tariff;

import org.intellij.lang.annotations.MagicConstant;

import java.util.ArrayList;
import java.util.HashMap;

public class IndividualsTariff implements Tariff, Cloneable {

    @MagicConstant(intValues = {SERVICE_CHARGE})
    private Service[] services;
    private int size = 0;
    public static final int SERVICE_CHARGE = 50;

    public IndividualsTariff() {
        services = new Service[8];
    }

    public IndividualsTariff(int size) {
        services = new Service[size];
    }

    public IndividualsTariff(Service[] services) {
        this.services = services;

        for (Service service : services) {
            if (service != null)
                size++;
        }

    }

    public boolean add(Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i] == null) {
                services[i] = service;
                size++;
                return true;
            }
        }

        increaseArray();
        return add(service);
    }

    public void increaseArray() {
        Service[] temp = new Service[services.length * 2];
        System.arraycopy(services, 0, temp, 0, services.length);
        services = temp;
    }

    public boolean add(int index, Service service) {
        if (index < services.length && services[index] == null) {
            services[index] = service;
            size++;
            return true;
        }

        return false;
    }

    public Service get(int index) {
        if (index < services.length) {
            return services[index];
        }

        return null;
    }

    public Service get(String serviceName) {
        for (Service service : services) {
            if (service != null && service.getName().equals(serviceName))
                return service;
        }

        return null;
    }

    public boolean hasService(String serviceName) {
        for (Service service : services) {
            if (service != null && service.getName().equals(serviceName))
                return true;
        }

        return false;
    }

    public Service set(int index, Service service) {
        if (index < services.length) {
            if (services[index] == null)
                size++;

            services[index] = service;
            return services[index];
        }

        return null;
    }

    public Service remove(int index) {
        if (index < services.length) {
            Service service = services[index];

            if (index != services.length - 1) {
                System.arraycopy(services, index + 1, services, index, services.length - index - 1);
            }

            if (services[services.length - 1] != null)
                services[services.length - 1] = null;

            if (service != null)
                size--;

            return service;
        }

        return null;
    }

    public Service remove(String serviceName) {
        for (int i = 0; i < services.length; i++) {
            if (services[i].getName().equals(serviceName)) {
                return remove(i);
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public Service[] getServices() {
        Service[] temp = new Service[size];
        for (int i = 0, j = 0; i < services.length; i++) {
            if (services[i] != null) {
                temp[j] = services[i];
                j++;
            }
        }

        return temp;
    }

    @Override
    public Service[] getServices(ServiceTypes type) {
        ArrayList<Service> list = new ArrayList<>();
        for (Service service : services) {
            if (service != null && service.getType() == type)
                list.add(service);
        }

        return list.toArray(new Service[list.size()]);
    }

    public Service[] sortedServicesByCost() {
        Service[] temp = getServices();

        for (int i = temp.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (temp[j].getCost() > temp[j+1].getCost()) {
                    Service service = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = service;
                }
            }
        }

        return temp;
    }

    public double cost() {
        double cost = 0;
        for (Service service : services) {
            if (service != null)
                cost += service.getCost();
        }

        return cost + SERVICE_CHARGE;
    }

    @Override
    public int hashCode() {
        int result = 31;

        for (Service service : services) {
            if (service != null)
                result *= service.hashCode();
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            IndividualsTariff tariff = (IndividualsTariff) obj;
            if (size == tariff.size) {
                Service[] services1 = getServices();
                Service[] services2 = tariff.getServices();
                for (int i = 0; i < size; i++) {
                    if (!services1[i].equals(services2[i]))
                        return false;
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public Tariff clone() throws CloneNotSupportedException {
        IndividualsTariff tariff = (IndividualsTariff) super.clone();

        for (int i = 0; i < services.length; i++) {
            if (services[i] != null)
                tariff.services[i] = services[i].clone();
        }

        return tariff;
    }

    @Override
    public boolean remove(Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i] != null && services[i].equals(service)) {
                return remove(i) != null;
            }
        }

        return false;
    }

    @Override
    public int indexOf(Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i] != null && services[i].equals(service)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Service service) {
        for (int i = services.length - 1; i >= 0; i--) {
            if (services[i] != null && services[i].equals(service)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Service service : services) {
            if (service != null)
                builder.append(service.toString());
        }

        return String.format("services:\n%s", builder.toString());
    }

}

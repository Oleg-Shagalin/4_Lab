package model;

import oop.model.IndividualsTariff;

public interface Account {

    long getNumber();
    Tariff getTariff();
    void setTariff(Tariff tariff);
}

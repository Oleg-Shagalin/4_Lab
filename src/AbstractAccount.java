package model;

import java.util.HashMap;

public abstract class AbstractAccount implements Account {
    private long number;
    private Tariff tariff;

    protected AbstractAccount(long number, Tariff tariff) {
        this.number = number;
        this.tariff = tariff;
    }

    @Override
    public long getNumber() {
        return number;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(number) * Integer.hashCode(tariff.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            AbstractAccount account = (AbstractAccount) obj;
            return number == account.number
                    && tariff.size() == account.tariff.size();
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("number: %d\n%s", number, tariff.toString());
    }
}

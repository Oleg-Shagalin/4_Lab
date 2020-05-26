package model;

import oop.model.Service;

public class EntityAccount extends AbstractAccount implements Account {

    private String name;

    public EntityAccount(long number, String name) {
        super(number, null);

        EntityTariff tariff = new EntityTariff();
        tariff.add(new Service());
        setTariff(tariff );

        this.name = name;
    }

    public EntityAccount(long number, String name, Tariff tariff) {
        super(number, tariff);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 53 * super.hashCode() * name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            EntityAccount account = (EntityAccount) obj;
            return name.equals(account.name)
                    && super.equals(obj);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Entity account:\nentity: %s\n%s", name, super.toString());
    }
}

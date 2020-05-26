import model.*;
import oop.model.*;

public class Test {

    public static void lab4tests() {
        Service[] services = new Service[3];
        services[0] = new Service();

        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service());
        for (Service s : tariff.getServices(ServiceTypes.INTERNET)) {
            System.out.println(s.toString());
            System.out.println(s.hashCode());
            System.out.println(s.equals(new Service()));
            System.out.println(s.equals(new Service("asd", 123, ServiceTypes.MAIL)));
            try {
                System.out.println(s.clone().toString());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        Person person = new Person("Ivan", "Ivanov");
        System.out.println(person.toString());
        System.out.println(person.hashCode());
        System.out.println(person.equals(new Person("Ivan", "Ivanov")));
        System.out.println(person.equals(new Person("Ivvan", "Ivanov")));

        Tariff entityTariff = new EntityTariff();
        entityTariff.add(new Service());
        System.out.println(entityTariff.toString());
        System.out.println(entityTariff.hashCode());
        System.out.println(entityTariff.equals(new EntityTariff()));
        Tariff entityTariff2 = new EntityTariff();
        entityTariff2.add(new Service("asd", 123, ServiceTypes.MAIL));
        System.out.println(entityTariff.equals(entityTariff2));
        try {
            System.out.println(entityTariff.clone().toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(entityTariff.indexOf(new Service()));
        System.out.println(entityTariff.lastIndexOf(new Service()));
        System.out.println(entityTariff.remove(new Service()));

        Tariff individualsTariff = new IndividualsTariff();
        individualsTariff.add(new Service());
        System.out.println(individualsTariff.toString());
        System.out.println(individualsTariff.hashCode());
        System.out.println(individualsTariff.equals(new IndividualsTariff()));
        Tariff individualsTariff2 = new IndividualsTariff();
        individualsTariff2.add(new Service());
        System.out.println(individualsTariff.equals(individualsTariff2));
        try {
            System.out.println(individualsTariff.clone().toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        individualsTariff.set(3, new Service("asd", 123, ServiceTypes.MAIL));
        individualsTariff.set(0, new Service("asd", 123, ServiceTypes.MAIL));
        individualsTariff.set(0, new Service());
        System.out.println(individualsTariff.indexOf(new Service()));
        System.out.println(individualsTariff.lastIndexOf(new Service()));
        System.out.println(individualsTariff.remove(new Service()));

        Account account = new IndividualAccount(3, new Person("Ivan", "Ivanov"), (IndividualsTariff) tariff);
        System.out.println(account.toString());
        System.out.println(account.hashCode());
        System.out.println(account.equals(new IndividualAccount(4, new Person("Petr", "Petrov"))));
        System.out.println(account.equals(new IndividualAccount(3, new Person("Ivan", "Ivanov"), (IndividualsTariff) tariff)));
        AbstractAccount account1 = new IndividualAccount(4, new Person("Petr", "Petrov"),
                new IndividualsTariff());
        System.out.println(account1.toString());
        System.out.println(account1.hashCode());
        System.out.println(account1.equals(account));

        Account entityAccount = new EntityAccount(4,"Petr");
        Account entityAccount1 = new EntityAccount(4,"Petr", entityTariff);
        System.out.println(entityAccount.toString());
        System.out.println(entityAccount.hashCode());
        System.out.println(entityAccount.equals(entityAccount1));


        Account[] accounts = new Account[2];
        accounts[0] = account;
        accounts[1] = entityAccount;
        AccountsManager manager = new AccountsManager(accounts);
        System.out.println(manager.toString());
        System.out.println(manager.indexOf(account));
        System.out.println(manager.remove(account));

    }

    @org.junit.Test
    public void startTests() {
        lab4tests();
    }

}

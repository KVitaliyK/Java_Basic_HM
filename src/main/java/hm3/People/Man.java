package hm3.People;

import hm3.Human;

public final class Man extends Human {

    public Man() {
        super();
    }

    public Man(String name, String surname, int day, int month, int year) {
        super(name, surname, day, month, year);
    }

    public Man(String name, String surname, int day, int month, int year, int iq, String[][] schedule) {
        super(name, surname, day, month, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() == null || getFamily().getPet() == null) {
            System.out.println("Я чоловік і в мене немає домашнього улюбленця.");
            return;
        }
        System.out.printf("Як справи, %s?%n", getFamily().getPet().getNickname());
    }

    public void repairCar() {
        System.out.println("Я лагоджу автомобіль.");
    }
}

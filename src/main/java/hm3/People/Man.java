package hm3.People;

import hm3.Human;
import hm3.Pet;

import java.util.Map;

public final class Man extends Human {

    public Man() {
        super();
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, Map<String,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() == null || getFamily().getPets().isEmpty()) {
            System.out.println("Я чоловік і в мене немає домашнього улюбленця.");
            return;
        }

        for (Pet p : getFamily().getPets()) {
            System.out.printf("Як справи, %s?%n", p.getNickname());
        }
    }

    public void repairCar() {
        System.out.println("Я лагоджу автомобіль.");
    }
}

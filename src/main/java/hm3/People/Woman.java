package hm3.People;

import hm3.Human;
import hm3.Pet;
import java.util.Map;

public final class Woman extends Human {

    public Woman() {
        super();
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Map<String,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() == null || getFamily().getPets().isEmpty()) {
            System.out.println("Я жінка і в мене немає домашнього улюбленця.");
            return;
        }

        for (Pet p : getFamily().getPets()) {
            System.out.printf("Привіт, мій %s!%n", p.getNickname());
        }
    }

    public void makeup() {
        System.out.println("Я роблю макіяж.");
    }
}

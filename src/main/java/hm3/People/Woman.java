package hm3.People;

import hm3.Human;

public final class Woman extends Human {

    public Woman() {
        super();
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() == null || getFamily().getPet() == null) {
            System.out.println("Я жінка і в мене немає домашнього улюбленця.");
            return;
        }
        System.out.printf("Привіт, мій %s!%n", getFamily().getPet().getNickname());
    }

    public void makeup() {
        System.out.println("Я роблю макіяж.");
    }
}

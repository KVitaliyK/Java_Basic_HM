package hm3;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public Human() {}

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, Map<String, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public void greetPet() {
        if (family == null || family.getPets().isEmpty()) {
            System.out.println("У мене немає домашніх улюбленців.");
            return;
        }

        for (Pet p : family.getPets()) {
            System.out.printf("Привіт, %s!%n", p.getNickname());
        }
    }

    public void describePet() {
        if (family == null || family.getPets().isEmpty()) {
            System.out.println("У мене немає домашніх улюбленців.");
            return;
        }

        for (Pet p : family.getPets()) {
            String cleverness = p.getTrickLevel() > 50 ? "дуже хитрий" : "майже не хитрий";

            System.out.printf(
                    "У мене є %s, йому %d років, він %s.%n",
                    p.getSpecies(), p.getAge(), cleverness
            );
        }
    }



    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getIq() { return iq; }
    public void setIq(int iq) { this.iq = iq; }

    public Map<String, String> getSchedule() { return schedule; }
    public void setSchedule(Map<String, String> schedule) { this.schedule = schedule; }

    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule=%s}",
                name, surname, year, iq, schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return year == human.year &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, schedule);
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Видаляється об'єкт Human: " + toString());
        super.finalize();
    }
}

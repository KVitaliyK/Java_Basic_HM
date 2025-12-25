package hm3;

import hm3.Animals.Dog;
import hm3.People.Man;
import hm3.People.Woman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // === PET ===
        Set<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");
        Pet dog = new Dog("Rock", 5, 75, habits);

        // === PARENTS ===
        Woman mother = new Woman("Jane", "Karleone", 1980);
        Man father = new Man("Vito", "Karleone", 1975);

        // === FAMILY ===
        Family family = new Family(mother, father);
        family.addPet(dog);

        // === SCHEDULE MAP ===
        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY.name(), "Gym");
        schedule.put(DayOfWeek.TUESDAY.name(), "Programming");
        schedule.put(DayOfWeek.WEDNESDAY.name(), "Cinema");
        schedule.put(DayOfWeek.THURSDAY.name(), "English");
        schedule.put(DayOfWeek.FRIDAY.name(), "Football");
        schedule.put(DayOfWeek.SATURDAY.name(), "Rest");
        schedule.put(DayOfWeek.SUNDAY.name(), "Family Day");

        Human child = new Human("Michael", "Karleone", 2005, 90, schedule);
        family.addChild(child);

        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        System.out.println("\n--- Методи підкласів ---");
        father.repairCar();
        mother.makeup();

        System.out.println("\n--- Family Info ---");
        System.out.println(family);

        System.out.println("\n--- Child Info ---");
        System.out.println(child);

        System.out.println("\n HM4");
        System.out.println("\n--- Створюємо багато Human для запуску GC ---");

        for (int i = 0; i < 10_000; i++) {
            new Human("Test" + i, "User", 2000 + (i % 20));
            if (i % 500_000 == 0) {
                System.out.println("Створено: " + i);
            }
        }

        System.out.println("Генерація завершена. Очікуємо роботу GC...\n");

        System.gc();
    }
}

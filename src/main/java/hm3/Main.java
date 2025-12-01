package hm3;

import hm3.Animals.Dog;
import hm3.People.Man;
import hm3.People.Woman;

public class Main {
    public static void main(String[] args) {

        // === PET ===
        Pet dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});

        // === PARENTS ===
        Woman mother = new Woman("Jane", "Karleone", 10, 1, 1980);
        Man father = new Man("Vito", "Karleone", 20, 5, 1975);

        // === FAMILY ===
        Family family = new Family(mother, father);
        family.setPet(dog);

        // === SCHEDULE ===
        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Gym"},
                {DayOfWeek.TUESDAY.name(), "Programming"},
                {DayOfWeek.WEDNESDAY.name(), "Cinema"},
                {DayOfWeek.THURSDAY.name(), "English"},
                {DayOfWeek.FRIDAY.name(), "Football"},
                {DayOfWeek.SATURDAY.name(), "Rest"},
                {DayOfWeek.SUNDAY.name(), "Family Day"}
        };

        // === CHILD ===
        Human child = new Human("Michael", "Karleone", 15, 4, 2005, 90, schedule);
        family.addChild(child);

        // === TESTING PET ===
        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        // === METHODS OF PARENTS ===
        System.out.println("\n--- Методи підкласів ---");
        father.repairCar();
        mother.makeup();

        // === FAMILY INFO ===
        System.out.println("\n--- Family Info ---");
        System.out.println(family);

        // === CHILD INFO + AGE ===
        System.out.println("\n--- Child Info ---");
        System.out.println(child);
        System.out.println("Вік дитини: " + child.describeAge());

        // === CREATE MANY HUMANS FOR GC TEST ===
        System.out.println("\n--- Створюємо багато Human для запуску GC ---");
        for (int i = 0; i < 10_000; i++) {
            new Human("Test" + i, "User", 1, 1, 2000 + (i % 20));
            if (i % 500_000 == 0) {
                System.out.println("Створено: " + i);
            }
        }

        System.out.println("Генерація завершена. Очікуємо роботу GC...\n");
        System.gc();
    }
}

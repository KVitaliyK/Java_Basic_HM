package hm3;

import hm3.Animals.Dog;
import hm3.People.Man;
import hm3.People.Woman;


public class Main {
    public static void main(String[] args) {

        // === PET ===
        Pet dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});


        // === PARENTS ===
        Woman mother = new Woman("Jane", "Karleone", 1980);
        Man father = new Man("Vito", "Karleone", 1975);

        // === FAMILY ===
        Family family = new Family(mother, father);
        family.setPet(dog);


        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Gym"},
                {DayOfWeek.TUESDAY.name(), "Programming"},
                {DayOfWeek.WEDNESDAY.name(), "Cinema"},
                {DayOfWeek.THURSDAY.name(), "English"},
                {DayOfWeek.FRIDAY.name(), "Football"},
                {DayOfWeek.SATURDAY.name(), "Rest"},
                {DayOfWeek.SUNDAY.name(), "Family Day"}
        };


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

package hm3;

import hm3.Animals.Dog;
import hm3.People.Man;
import hm3.People.Woman;
import hm3.Dao.FamilyController;
import hm3.Dao.FamilyService;
import hm3.Dao.CollectionFamilyDao;
import hm3.Dao.FamilyDao;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // === DAO & SERVICE & CONTROLLER ===
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        // === PET ===
        Pet dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});

        // === PARENTS ===
        Woman mother = new Woman("Jane", "Karleone", 10, 1, 1980);
        Man father = new Man("Vito", "Karleone", 20, 5, 1975);

        // === CREATE FAMILY THROUGH CONTROLLER ===
        Family family = familyController.createNewFamily(mother, father);

        // === ADD PET ===
        familyController.addPet(0, dog);

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

        // === ADD CHILD ===
        Human child = new Human("Michael", "Karleone", 15, 4, 2005, 90, schedule);
        familyController.adoptChild(family, child);

        // === DISPLAY ALL FAMILIES ===
        System.out.println("\n--- Display All Families ---");
        familyController.displayAllFamilies();

        // === GET FAMILIES BIGGER THAN 3 PEOPLE ===
        System.out.println("\n--- Families Bigger Than 3 ---");
        familyController.getFamiliesBiggerThan(3);

        // === GET FAMILIES LESS THAN 5 PEOPLE ===
        System.out.println("\n--- Families Less Than 5 ---");
        familyController.getFamiliesLessThan(5);

        // === COUNT FAMILIES WITH 4 MEMBERS ===
        int count = familyController.countFamiliesWithMemberNumber(4);
        System.out.println("\nNumber of families with 4 members: " + count);

        // === BORN CHILD ===
        familyController.bornChild(family, "Anthony", "Maria");
        System.out.println("\n--- Family After Born Child ---");
        familyController.displayAllFamilies();

        // === DELETE CHILDREN OLDER THAN 18 ===
        familyController.deleteAllChildrenOlderThen(18);
        System.out.println("\n--- Family After Deleting Children Older Than 18 ---");
        familyController.displayAllFamilies();

        // === COUNT FAMILIES ===
        System.out.println("\nTotal number of families: " + familyController.count());

        // === GET PETS ===
        System.out.println("\nPets in family:");
        List<Pet> pets = familyController.getPets(0);
        if (pets != null) pets.forEach(p -> System.out.println(p.getNickname()));

        // === DELETE FAMILY BY INDEX ===
        boolean deleted = familyController.deleteFamilyByIndex(0);
        System.out.println("\nFamily deleted: " + deleted);

        System.out.println("\n--- Final List of Families ---");
        familyController.displayAllFamilies();

        // === TESTING HUMAN METHODS ===
        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        // === METHODS OF PARENTS ===
        System.out.println("\n--- Methods of Parents ---");
        father.repairCar();
        mother.makeup();

        // === FAMILY INFO + CHILD AGE ===
        System.out.println("\n--- Family Info ---");
        System.out.println(family);
        System.out.println("\n--- Child Info ---");
        System.out.println(child);
        System.out.println("Child age: " + child.describeAge());

        // === CREATE MANY HUMANS FOR GC TEST ===
        System.out.println("\n--- Creating many Humans for GC ---");
        for (int i = 0; i < 10_000; i++) {
            new Human("Test" + i, "User", 1, 1, 2000 + (i % 20));
        }

        System.out.println("Generation complete. Triggering GC...");
        System.gc();
    }
}

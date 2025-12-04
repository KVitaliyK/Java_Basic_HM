package hm3;

import hm3.Animals.Dog;
import hm3.People.Man;
import hm3.People.Woman;
import hm3.Dao.FamilyController;
import hm3.Dao.FamilyService;
import hm3.Dao.CollectionFamilyDao;
import hm3.Dao.FamilyDao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        // === DAO & SERVICE & CONTROLLER ===
//        FamilyDao familyDao = new CollectionFamilyDao();
//        FamilyService familyService = new FamilyService(familyDao);
//        FamilyController familyController = new FamilyController(familyService);
//
//        // === PET ===
//        Pet dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
//
//        // === PARENTS ===
//        Woman mother = new Woman("Jane", "Karleone", 10, 1, 1980);
//        Man father = new Man("Vito", "Karleone", 20, 5, 1975);
//
//        // === CREATE FAMILY THROUGH CONTROLLER ===
//        Family family = familyController.createNewFamily(mother, father);
//
//        // === ADD PET ===
//        familyController.addPet(0, dog);
//
//        // === SCHEDULE ===
//        String[][] schedule = {
//                {DayOfWeek.MONDAY.name(), "Gym"},
//                {DayOfWeek.TUESDAY.name(), "Programming"},
//                {DayOfWeek.WEDNESDAY.name(), "Cinema"},
//                {DayOfWeek.THURSDAY.name(), "English"},
//                {DayOfWeek.FRIDAY.name(), "Football"},
//                {DayOfWeek.SATURDAY.name(), "Rest"},
//                {DayOfWeek.SUNDAY.name(), "Family Day"}
//        };
//
//        // === ADD CHILD ===
//        Human child = new Human("Michael", "Karleone", 15, 4, 2005, 90, schedule);
//        familyController.adoptChild(family, child);
//
//        // === DISPLAY ALL FAMILIES ===
//        System.out.println("\n--- Display All Families ---");
//        familyController.displayAllFamilies();
//
//        // === GET FAMILIES BIGGER THAN 3 PEOPLE ===
//        System.out.println("\n--- Families Bigger Than 3 ---");
//        familyController.getFamiliesBiggerThan(3);
//
//        // === GET FAMILIES LESS THAN 5 PEOPLE ===
//        System.out.println("\n--- Families Less Than 5 ---");
//        familyController.getFamiliesLessThan(5);
//
//        // === COUNT FAMILIES WITH 4 MEMBERS ===
//        int count = familyController.countFamiliesWithMemberNumber(4);
//        System.out.println("\nNumber of families with 4 members: " + count);
//
//        // === BORN CHILD ===
//        familyController.bornChild(family, "Anthony", "Maria");
//        System.out.println("\n--- Family After Born Child ---");
//        familyController.displayAllFamilies();
//
//        // === DELETE CHILDREN OLDER THAN 18 ===
////        familyController.deleteAllChildrenOlderThen(18);
////        System.out.println("\n--- Family After Deleting Children Older Than 18 ---");
////        familyController.displayAllFamilies();
//
//        // === COUNT FAMILIES ===
//        System.out.println("\nTotal number of families: " + familyController.count());
//
//        // === GET PETS ===
//        System.out.println("\nPets in family:");
//        List<Pet> pets = familyController.getPets(0);
//        if (pets != null) pets.forEach(p -> System.out.println(p.getNickname()));
//
//        // === DELETE FAMILY BY INDEX ===
//        boolean deleted = familyController.deleteFamilyByIndex(0);
//        System.out.println("\nFamily deleted: " + deleted);
//
//        System.out.println("\n--- Final List of Families ---");
//        familyController.displayAllFamilies();
//
//        // === TESTING HUMAN METHODS ===
//        child.greetPet();
//        child.describePet();
//        dog.eat();
//        dog.respond();
//        dog.foul();
//
//        // === METHODS OF PARENTS ===
//        System.out.println("\n--- Methods of Parents ---");
//        father.repairCar();
//        mother.makeup();
//
//        // === FAMILY INFO + CHILD AGE ===
//        System.out.println("\n--- Family Info ---");
//        System.out.println(family);
//        System.out.println("\n--- Child Info ---");
//        System.out.println(child);
//        System.out.println("Child age: " + child.describeAge());
//
//
//
//        // === PRETTY FORMAT OUTPUT ===
//        System.out.println("\n--- Pretty Format Family ---");
//        System.out.println(family.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Mother ---");
//        System.out.println(mother.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Father ---");
//        System.out.println(father.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Child ---");
//        System.out.println(child.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Pet ---");
//        System.out.println(dog.prettyFormat());
//
//
//        // === PRETTY FORMAT OUTPUT ===
//        System.out.println("\n--- Pretty Format Family ---");
//        System.out.println(family.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Mother ---");
//        System.out.println(mother.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Father ---");
//        System.out.println(father.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Child ---");
//        System.out.println(child.prettyFormat());
//
//        System.out.println("\n--- Pretty Format Pet ---");
//        System.out.println(dog.prettyFormat());
//
//        // === CREATE MANY HUMANS FOR GC TEST ===
//        System.out.println("\n--- Creating many Humans for GC ---");
//        for (int i = 0; i < 10_000; i++) {
//            new Human("Test" + i, "User", 1, 1, 2000 + (i % 20));
//        }
//
//        System.out.println("Generation complete. Triggering GC...");
//        System.gc();
//    }


        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n=== Головне меню ===");
                System.out.println("1. Заповнити тестовими даними");
                System.out.println("2. Відобразити весь список сімей");
                System.out.println("3. Відобразити сім'ї більші за певну кількість людей");
                System.out.println("4. Відобразити сім'ї менші за певну кількість людей");
                System.out.println("5. Підрахувати кількість сімей з певною кількістю членів");
                System.out.println("6. Створити нову родину");
                System.out.println("7. Видалити сім'ю за індексом");
                System.out.println("8. Редагувати сім'ю");
                System.out.println("9. Видалити всіх дітей старше заданого віку");
                System.out.println("0. Вихід");
                System.out.print("Виберіть команду: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> { // Заповнити тестовими даними
                        Woman mother = new Woman("Jane", "Karleone", 10, 1, 1980);
                        Man father = new Man("Vito", "Karleone", 20, 5, 1975);
                        Family family = familyController.createNewFamily(mother, father);

                        Human child1 = new Human("Michael", "Karleone", 15, 4, 2005, 90, null);
                        familyController.adoptChild(family, child1);

                        Pet dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
                        familyController.addPet(0, dog);

                        System.out.println("Тестові дані створено!");
                    }
                    case 2 -> familyController.displayAllFamilies();
                    case 3 -> {
                        System.out.print("Введіть число: ");
                        int num = Integer.parseInt(scanner.nextLine().trim());
                        familyController.getFamiliesBiggerThan(num);
                    }
                    case 4 -> {
                        System.out.print("Введіть число: ");
                        int num = Integer.parseInt(scanner.nextLine().trim());
                        familyController.getFamiliesLessThan(num);
                    }
                    case 5 -> {
                        System.out.print("Введіть число: ");
                        int num = Integer.parseInt(scanner.nextLine().trim());
                        int count = familyController.countFamiliesWithMemberNumber(num);
                        System.out.println("Кількість сімей: " + count);
                    }
                    case 6 -> {
                        System.out.println("Введіть дані матері:");
                        System.out.print("Ім'я: "); String motherName = scanner.nextLine().trim();
                        System.out.print("Прізвище: "); String motherSurname = scanner.nextLine().trim();
                        int motherYear = readInt(scanner, "Рік народження: ");
                        int motherMonth = readInt(scanner, "Місяць народження: ", 1, 12);
                        int motherDay = readInt(scanner, "День народження: ", 1, 31);
                        int motherIQ = readInt(scanner, "IQ: ", 0, 300);
                        Woman mother = new Woman(motherName, motherSurname, motherDay, motherMonth, motherYear, motherIQ, null);

                        System.out.println("Введіть дані батька:");
                        System.out.print("Ім'я: "); String fatherName = scanner.nextLine().trim();
                        System.out.print("Прізвище: "); String fatherSurname = scanner.nextLine().trim();
                        int fatherYear = readInt(scanner, "Рік народження: ");
                        int fatherMonth = readInt(scanner, "Місяць народження: ", 1, 12);
                        int fatherDay = readInt(scanner, "День народження: ", 1, 31);
                        int fatherIQ = readInt(scanner, "IQ: ", 0, 300);
                        Man father = new Man(fatherName, fatherSurname, fatherDay, fatherMonth, fatherYear, fatherIQ, null);

                        familyController.createNewFamily(mother, father);
                        System.out.println("Нова родина створена!");
                    }
                    case 7 -> {
                        int index = readInt(scanner, "Введіть порядковий номер сім'ї для видалення: ", 1, familyController.count()) - 1;
                        boolean deleted = familyController.deleteFamilyByIndex(index);
                        System.out.println("Сім'ю видалено: " + deleted);
                    }
                    case 8 -> {
                        int index = readInt(scanner, "Введіть порядковий номер сім'ї для редагування: ", 1, familyController.count()) - 1;
                        Family family = familyController.getFamilyById(index);
                        if (family == null) {
                            System.out.println("Сім'ю не знайдено!");
                            break;
                        }

                        while (true) {
                            System.out.println("1. Народити дитину");
                            System.out.println("2. Усиновити дитину");
                            System.out.println("3. Повернутися до головного меню");
                            int subChoice = readInt(scanner, "Виберіть команду: ", 1, 3);

                            if (subChoice == 1) {
                                System.out.print("Ім'я для хлопчика: "); String boyName = scanner.nextLine().trim();
                                System.out.print("Ім'я для дівчинки: "); String girlName = scanner.nextLine().trim();
                                familyController.bornChild(family, boyName, girlName);
                                System.out.println("Дитина народжена!");
                            } else if (subChoice == 2) {
                                System.out.print("Ім'я: "); String name = scanner.nextLine().trim();
                                System.out.print("Прізвище: "); String surname = scanner.nextLine().trim();
                                int year = readInt(scanner, "Рік народження: ");
                                int iq = readInt(scanner, "IQ: ", 0, 300);
                                Human child = new Human(name, surname, 1, 1, year, iq, null);
                                familyController.adoptChild(family, child);
                                System.out.println("Дитина усиновлена!");
                            } else break;
                        }
                    }
                    case 9 -> {
                        int age = readInt(scanner, "Введіть вік: ", 0, 150);
                        familyController.deleteAllChildrenOlderThen(age);
                        System.out.println("Діти старше " + age + " років видалені.");
                    }
                    case 0 -> {
                        System.out.println("Вихід з програми...");
                        return;
                    }
                    default -> System.out.println("Невірна команда!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Помилка: введено некоректне число, спробуйте ще раз.");
            } catch (InputMismatchException e) {
                System.out.println("Помилка: неправильний тип даних, спробуйте ще раз.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Сталася помилка: " + e.getMessage());
            }
        }
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть ціле число!");
            }
        }
    }

    private static int readInt(Scanner scanner, String message, int min, int max) {
        while (true) {
            int value = readInt(scanner, message);
            if (value >= min && value <= max) return value;
            System.out.printf("Помилка: число повинно бути від %d до %d%n", min, max);
        }
    }

}

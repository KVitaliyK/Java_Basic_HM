package hm3.Dao;

import hm3.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class FamilyService {

    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }


    private int calculateAge(Human human) {
        LocalDate birth = Instant.ofEpochMilli(human.getBirthDate())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(birth, LocalDate.now()).getYears();
    }


    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();

        if (families.isEmpty()) {
            System.out.println("Список сімей порожній.");
            return;
        }

        for (int i = 0; i < families.size(); i++) {
            System.out.printf("%d: %s%n", i, families.get(i));
        }
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> result = new ArrayList<>();

        for (Family f : familyDao.getAllFamilies()) {
            if (f.countFamily() > number) {
                result.add(f);
            }
        }

        result.forEach(System.out::println);
        return result;
    }

    public List<Family> getFamiliesLessThan(int number) {
        List<Family> result = new ArrayList<>();

        for (Family f : familyDao.getAllFamilies()) {
            if (f.countFamily() < number) {
                result.add(f);
            }
        }

        result.forEach(System.out::println);
        return result;
    }

    public int countFamiliesWithMemberNumber(int number) {
        int count = 0;

        for (Family f : familyDao.getAllFamilies()) {
            if (f.countFamily() == number) count++;
        }

        return count;
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        return familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }



    public Family bornChild(Family family, String boyName, String girlName) {

        boolean isBoy = Math.random() < 0.5;
        String name = isBoy ? boyName : girlName;

        LocalDate today = LocalDate.now();

        Human child = new Human(
                name,
                family.getFather().getSurname(),
                today.getDayOfMonth(),
                today.getMonthValue(),
                today.getYear()
        );

        family.addChild(child);
        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family family : familyDao.getAllFamilies()) {

            Human[] children = family.getChildren();

            for (int i = 0; i < children.length; i++) {
                int childAge = calculateAge(children[i]);
                if (childAge > age) {
                    family.deleteChild(i);
                    i--;
                }
            }

            familyDao.saveFamily(family);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }




    public List<Pet> getPets(int familyIndex) {
        Family f = familyDao.getFamilyByIndex(familyIndex);
        if (f == null) return null;

        List<Pet> pets = new ArrayList<>();
        if (f.getPet() != null) pets.add(f.getPet());
        return pets;
    }

    public void addPet(int index, Pet pet) {
        Family f = familyDao.getFamilyByIndex(index);
        if (f != null) {
            f.setPet(pet);
            familyDao.saveFamily(f);
        }
    }
}

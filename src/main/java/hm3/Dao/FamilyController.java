package hm3.Dao;

import hm3.*;
import hm3.Exeptions.FamilyOverflowException;

import java.util.List;

public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }



    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        return familyService.getFamiliesBiggerThan(number);
    }

    public List<Family> getFamiliesLessThan(int number) {
        return familyService.getFamiliesLessThan(number);
    }

    public int countFamiliesWithMemberNumber(int number) {
        return familyService.countFamiliesWithMemberNumber(number);
    }

    public Family createNewFamily(Human mother, Human father) {
        return familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }


    public Family bornChild(Family family, String boyName, String girlName) {
        try {
            return familyService.bornChild(family, boyName, girlName);
        } catch (FamilyOverflowException e) {
            System.out.println("Помилка: " + e.getMessage());
            return family;
        }
    }

    public Family adoptChild(Family family, Human child) {
        try {
            return familyService.adoptChild(family, child);
        } catch (FamilyOverflowException e) {
            System.out.println("Помилка: " + e.getMessage());
            return family;
        }
    }


    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }



    public List<Pet> getPets(int familyIndex) {
        return familyService.getPets(familyIndex);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}

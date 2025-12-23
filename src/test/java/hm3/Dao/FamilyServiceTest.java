package hm3.Dao;

import hm3.*;

import hm3.People.Man;
import hm3.People.Woman;
import hm3.Animals.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {

    private FamilyDao familyDao;
    private FamilyService familyService;
    private Family family;
    private Human mother;
    private Human father;
    private Pet dog;

    @BeforeEach
    void setUp() {
        familyDao = new CollectionFamilyDao();
        familyService = new FamilyService(familyDao);

        mother = new Woman("Jane", "Doe", 1, 1, 1980);
        father = new Man("John", "Doe", 1, 1, 1975);
        family = familyService.createNewFamily(mother, father);

        dog = new Dog("Rock", 5, 75, new String[]{"eat", "sleep"});
        familyService.addPet(0, dog);
    }

    @Test
    void testGetAllFamilies() {
        List<Family> families = familyService.getAllFamilies();
        assertEquals(1, families.size());
        assertEquals(family, families.get(0));
    }

    @Test
    void testDisplayAllFamilies() {
        assertDoesNotThrow(() -> familyService.displayAllFamilies());
    }

    @Test
    void testGetFamiliesBiggerThan() {
        Human child1 = new Human("Child1", "Doe", 1,1,2005);
        familyService.adoptChild(family, child1);
        List<Family> biggerFamilies = familyService.getFamiliesBiggerThan(2);
        assertTrue(biggerFamilies.contains(family));
    }

    @Test
    void testGetFamiliesLessThan() {
        List<Family> lessFamilies = familyService.getFamiliesLessThan(5);
        assertTrue(lessFamilies.contains(family));
    }

        @Test
        void testCountFamiliesWithMemberNumber() {
            assertEquals(2, familyService.countFamiliesWithMemberNumber(2)); // only parents initially
            Human child1 = new Human("Child1", "Doe", 1,1,2005);
            familyService.adoptChild(family, child1);
            assertEquals(1, familyService.countFamiliesWithMemberNumber(3));
        }

    @Test
    void testCreateNewFamily() {
        Human m = new Woman("Alice", "Smith", 2,2,1985);
        Human f = new Man("Bob", "Smith", 3,3,1980);
        Family newFamily = familyService.createNewFamily(m,f);
        assertTrue(familyService.getAllFamilies().contains(newFamily));
    }

    @Test
    void testDeleteFamilyByIndex() {
        boolean deleted = familyService.deleteFamilyByIndex(0);
        assertTrue(deleted);
        assertEquals(0, familyService.count());
    }

    @Test
    void testGetFamilyById() {
        Family f = familyService.getFamilyById(0);
        assertEquals(family, f);
        assertNull(familyService.getFamilyById(999));
    }

    @Test
    void testBornChild() {
        Family f = familyService.bornChild(family, "Anthony", "Maria");
        assertEquals(1, f.getChildren().length);
        assertTrue(f.getChildren()[0].getName().equals("Anthony") || f.getChildren()[0].getName().equals("Maria"));
    }

    @Test
    void testAdoptChild() {
        Human child = new Human("Michael", "Doe", 1,1,2010);
        Family f = familyService.adoptChild(family, child);
        assertTrue(f.getChildren().length > 0);
        assertEquals("Michael", f.getChildren()[0].getName());
    }


    @Test
    void testCount() {
        assertEquals(1, familyService.count());
    }

    @Test
    void testGetPets() {
        List<Pet> pets = familyService.getPets(0);
        assertNotNull(pets);
        assertEquals(1, pets.size());
        assertEquals(dog, pets.get(0));
    }

    @Test
    void testAddPet() {
        Pet cat = new Dog("Cat", 3, 50, new String[]{"sleep"});
        familyService.addPet(0, cat);
        List<Pet> pets = familyService.getPets(0);
        assertEquals(cat, pets.get(0));
    }
}

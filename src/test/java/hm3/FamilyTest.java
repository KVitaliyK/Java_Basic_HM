package hm3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {

    private Family family;
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;

    @BeforeEach
    void setUp() {
        mother = new Human("Jane", "Karleone", 1980);
        father = new Human("Vito", "Karleone", 1975);

        family = new Family(mother, father);

        child1 = new Human("Michael", "Karleone", 2005);
        child2 = new Human("Anthony", "Karleone", 2008);

        family.addChild(child1);
        family.addChild(child2);
    }


    // TEST toString()

    @Test
    void testToString() {
        String result = family.toString();

        assertTrue(result.contains("mother=Human"));
        assertTrue(result.contains("father=Human"));
        assertTrue(result.contains("children="));
        assertTrue(result.contains("Michael"));
        assertTrue(result.contains("Anthony"));
    }


    // TEST deleteChild(Human child)


    @Test
    void testDeleteChildByObject_Positive() {
        boolean removed = family.deleteChild(child1);

        assertTrue(removed);
        assertEquals(1, family.getChildren().length);
        assertNotEquals(child1, family.getChildren()[0]);
    }

    @Test
    void testDeleteChildByObject_Negative() {
        Human stranger = new Human("Random", "Guy", 1999);

        boolean removed = family.deleteChild(stranger);

        assertFalse(removed);
        assertEquals(2, family.getChildren().length);
    }


    // TEST deleteChild(int index)


    @Test
    void testDeleteChildByIndex_Positive() {
        boolean removed = family.deleteChild(0);

        assertTrue(removed);
        assertEquals(1, family.getChildren().length);
        assertNotEquals(child1, family.getChildren()[0]);
    }

    @Test
    void testDeleteChildByIndex_Negative() {
        boolean removed = family.deleteChild(50);

        assertFalse(removed);
        assertEquals(2, family.getChildren().length);
    }


    // TEST addChild(Human child)


    @Test
    void testAddChild() {
        Human newChild = new Human("Sonny", "Karleone", 2010);

        int oldLength = family.getChildren().length;
        family.addChild(newChild);

        assertEquals(oldLength + 1, family.getChildren().length);
        assertEquals(newChild, family.getChildren()[family.getChildren().length - 1]);

         assertEquals(family, newChild.getFamily());
    }


    // TEST countFamily()


    @Test
    void testCountFamily() {
        // 2 батьки + 2 дітей = 4
        assertEquals(4, family.countFamily());
    }
}

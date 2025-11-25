package hm3.Animals;

import hm3.Pet;
import hm3.Species;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(Species.DOG, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Я пес " + getNickname() + "!");
    }

    @Override
    public void foul() {
        System.out.println("Я трохи наробив безладу");
    }
}

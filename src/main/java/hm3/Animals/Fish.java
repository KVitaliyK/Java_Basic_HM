package hm3.Animals;

import hm3.Pet;
import hm3.Species;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(Species.FISH, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Я рибка " + getNickname());
    }
}

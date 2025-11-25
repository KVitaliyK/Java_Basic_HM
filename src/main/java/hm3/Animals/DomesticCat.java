package hm3.Animals;

import hm3.Pet;
import hm3.Species;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(Species.DOMESTIC_CAT, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Мяу! Я киця " + getNickname() + "!");
    }

    @Override
    public void foul() {
        System.out.println("Я знову щось розбила");
    }
}

package hm3;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet() {}

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("Я їм!");
    }

    public void respond() {
        System.out.printf("Привіт, господарю. Я - %s!%n", nickname);
    }

    public void foul() {
        System.out.println("Потрібно добре прибрати за собою!");
    }


    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getTrickLevel() { return trickLevel; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }

    public String[] getHabits() { return habits; }
    public void setHabits(String[] habits) { this.habits = habits; }

    @Override
    public String toString() {
        return String.format("Pet{species='%s', nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species, nickname, age, trickLevel, Arrays.toString(habits));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname) &&
                Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }
}

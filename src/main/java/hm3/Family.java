package hm3;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();

        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public List<Human> getChildren() { return children; }
    public Set<Pet> getPets() { return pets; }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public boolean removePet(Pet pet) {
        return pets.remove(pet);
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) return false;
        Human removed = children.remove(index);
        if (removed != null) removed.setFamily(null);
        return true;
    }

    public boolean deleteChild(Human child) {
        if (children.remove(child)) {
            child.setFamily(null);
            return true;
        }
        return false;
    }

    public int countFamily() {
        return 2 + children.size() + pets.size();
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pets=%s}",
                mother.getName(),
                father.getName(),
                children,
                pets.isEmpty() ? "немає" : pets.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children) &&
                Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Видаляється об'єкт Family: " + toString());
        super.finalize();
    }
}

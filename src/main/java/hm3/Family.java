package hm3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Family implements Serializable {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];

        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public Human[] getChildren() { return children; }
    public Pet getPet() { return pet; }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child) {
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;

        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }

        children = newChildren;
        return true;
    }

    public boolean deleteChild(Human child) {
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                return deleteChild(i);
            }
        }
        return false;
    }

    public int countFamily() {
        return 2 + children.length + (pet != null ? 1 : 0);
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}",
                mother.getName(), father.getName(),
                Arrays.toString(children),
                pet != null ? pet.getNickname() : "немає");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Видаляється об'єкт Family: " + toString());
        super.finalize();
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n");

        // mother
        sb.append("\tmother: ")
                .append(mother != null ? mother.prettyFormat() : "null")
                .append("\n");

        // father
        sb.append("\tfather: ")
                .append(father != null ? father.prettyFormat() : "null")
                .append("\n");

        // children
        sb.append("\tchildren:\n");
        if (children == null || children.length == 0) {
            sb.append("\t\t(no children)\n");
        } else {
            for (Human child : children) {
                String gender = child.getClass().getSimpleName().toLowerCase(); // man/girl/woman/boy
                sb.append("\t\t")
                        .append(gender)
                        .append(": ")
                        .append(child.prettyFormat())
                        .append("\n");
            }
        }

        // pets
        sb.append("\tpets: ");
        if (pet == null) {
            sb.append("[]");
        } else {
            sb.append("[")
                    .append(pet.prettyFormat())
                    .append("]");
        }

        return sb.toString();
    }

}

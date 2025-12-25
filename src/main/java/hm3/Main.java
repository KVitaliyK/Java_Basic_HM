package hm3;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Pet("dog", "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});

        Human mother = new Human("Jane", "Karleone", 1980);
        Human father = new Human("Vito", "Karleone", 1975);

        Family family = new Family(mother, father);
        family.setPet(dog);

        String[][] schedule = {
                {"Monday", "Gym"},
                {"Tuesday", "Programming"},
                {"Wednesday", "Cinema"}
        };

        Human child = new Human("Michael", "Karleone", 2005, 90, schedule);

        family.addChild(child);

        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        System.out.println("\n--- Family Info ---");
        System.out.println(family);

        System.out.println("\n--- Child Info ---");
        System.out.println(child);
    }
}

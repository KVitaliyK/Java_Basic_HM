package hm3;

public enum Species {
    DOG,
    CAT,
    FISH,
    BIRD,
    HAMSTER,
    RABBIT,
    SNAKE,
    TURTLE,
    DOMESTIC_CAT,
    ROBO_CAT,
    UNKNOWN;

    public static Species fromString(String value) {
        if (value == null) return UNKNOWN;

        for (Species s : Species.values()) {
            if (s.name().equals(value)) {
                return s;
            }
        }
        return UNKNOWN;
    }
}

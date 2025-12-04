package hm3;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human() {}

    public Human(String name, String surname, int day, int month, int year) {
        this.name = name;
        this.surname = surname;
        setBirthDate(day, month, year);
    }

    public Human(String name, String surname, int day, int month, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        setBirthDate(day, month, year);
        this.iq = iq;
        this.schedule = schedule;
    }

    public void greetPet() {
        if (family == null || family.getPet() == null) {
            System.out.println("У мене немає домашнього улюбленця.");
            return;
        }
        System.out.printf("Привіт, %s!%n", family.getPet().getNickname());
    }

    public void describePet() {
        if (family == null || family.getPet() == null) {
            System.out.println("У мене немає домашнього улюбленця.");
            return;
        }

        Pet p = family.getPet();
        String cleverness = p.getTrickLevel() > 50 ? "дуже хитрий" : "майже не хитрий";

        System.out.printf("У мене є %s, йому %d років, він %s.%n",
                p.getSpecies(), p.getAge(), cleverness);
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public long getBirthDate() { return birthDate; }
    public void setBirthDate(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        this.birthDate = date.atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    public int getIq() { return iq; }
    public void setIq(int iq) { this.iq = iq; }

    public String[][] getSchedule() { return schedule; }
    public void setSchedule(String[][] schedule) { this.schedule = schedule; }

    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }


    public String describeAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = LocalDate.now();
        Period p = Period.between(birth, now);
        return String.format("%d років, %d місяців, %d днів", p.getYears(), p.getMonths(), p.getDays());
    }

    @Override
    public String toString() {
        LocalDate birth = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        String formattedDate = birth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return String.format("Human{name='%s', surname='%s', birthDate=%s, iq=%d, schedule=%s}",
                name, surname, formattedDate, iq, Arrays.deepToString(schedule));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Видаляється об'єкт Human: " + toString());
        super.finalize();
    }

    public String prettyFormat() {
        // Дата
        LocalDate birth = Instant.ofEpochMilli(birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        String formattedDate = birth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Розклад
        String scheduleStr;
        if (schedule == null) {
            scheduleStr = "null";
        } else {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < schedule.length; i++) {
                sb.append(schedule[i][0]).append("=").append(schedule[i][1]);
                if (i < schedule.length - 1) sb.append(", ");
            }
            sb.append("}");
            scheduleStr = sb.toString();
        }

        return String.format(
                "{name='%s', surname='%s', birthDate='%s', iq=%d, schedule=%s}",
                name, surname, formattedDate, iq, scheduleStr
        );
    }

}

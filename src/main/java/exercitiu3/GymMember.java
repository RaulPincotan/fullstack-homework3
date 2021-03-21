package exercitiu3;

import java.time.LocalDate;
import java.util.Objects;

public class GymMember {
    private final String name;
    private final LocalDate dateOfBirth;

    public GymMember(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public int getAge() {
        if (LocalDate.now().getMonth().getValue() >= dateOfBirth.getMonth().getValue()) {
            return LocalDate.now().getYear() - dateOfBirth.getYear();
        } else {
            return (LocalDate.now().getYear() - dateOfBirth.getYear()) - 1;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymMember gymMember = (GymMember) o;
        return Objects.equals(name, gymMember.name) && Objects.equals(dateOfBirth, gymMember.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth);
    }

    @Override
    public String toString() {
        return "GymMember{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ",age='" + getAge()
                +
                '}';
    }
}

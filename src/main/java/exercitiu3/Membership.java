package exercitiu3;

import java.util.Objects;

public class Membership {
    private final GymMember gymMember;
    private int remainingTime;

    public Membership(GymMember gymMember, int remainingTime) {
        this.gymMember = gymMember;
        this.remainingTime = remainingTime;
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return remainingTime == that.remainingTime && Objects.equals(gymMember, that.gymMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymMember, remainingTime);
    }

    @Override
    public String toString() {
        return "Membership{" +
                "gymMember=" + gymMember +
                ", remainingTime=" + remainingTime +
                '}';
    }
}

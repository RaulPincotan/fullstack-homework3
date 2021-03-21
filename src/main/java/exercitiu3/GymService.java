package exercitiu3;

import java.util.*;

public class GymService {
    private final List<Membership> memberships = new ArrayList<>();

    public GymService(Collection<Membership> memberships) {
        if (memberships != null) {
            this.memberships.addAll(memberships);
        }
    }

    public void addTime(Membership membership, int time) {
        Optional<Membership> membership1 = Optional.ofNullable(membership);
        membership1.ifPresent(m -> m.setRemainingTime(m.getRemainingTime() + time));
    }

    public void spendTime(Membership membership, int time) {
        Optional<Membership> membership1 = Optional.ofNullable(membership);
        membership1.ifPresent(m -> m.setRemainingTime(m.getRemainingTime() - time));
    }

    public OptionalDouble getAverageAge() {
        return memberships.stream()
                .mapToInt(membership -> membership.getGymMember().getAge())
                .average();
    }

    public OptionalInt getOldestMember() {
        return memberships.stream()
                .mapToInt(membership -> membership.getGymMember().getAge())
                .max();
    }

    public OptionalInt getYoungestMember() {
        return memberships.stream()
                .mapToInt(membership -> membership.getGymMember().getAge())
                .min();
    }

    public Optional<Membership> findMembershipByName(String name) {
        Optional<Membership> member = memberships.stream()
                .filter(m -> m.getGymMember().getName().equalsIgnoreCase(name))
                .findFirst();
        return Optional.ofNullable(member).orElse(Optional.empty());
    }


    public List<Membership> getMemberships() {
        return new ArrayList<>(memberships);
    }
}

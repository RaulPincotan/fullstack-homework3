package exercitiu2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(Collection<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }


    public Predicate<Person> checkPredicateAge(int age) {
        return p -> p.getAge() >= age;
    }


    public List<Person> selectedPersons(Predicate predicate, Function<Predicate, String> function) {
        return (List<Person>) persons.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}

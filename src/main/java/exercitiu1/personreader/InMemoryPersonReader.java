package exercitiu1.personreader;

import exercitiu1.entity.Person;

import java.util.List;

public class InMemoryPersonReader implements PersonReader {

    @Override
    public List<Person> readPersons() {
        return List.of(new Person("Raul", "Pincotan", 29));
    }


}

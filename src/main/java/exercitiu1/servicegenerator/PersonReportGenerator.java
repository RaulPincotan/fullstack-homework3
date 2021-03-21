package exercitiu1.servicegenerator;

import exercitiu1.entity.Person;
import exercitiu1.personreader.PersonReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersonReportGenerator {
    private final PersonReader reader;

    public PersonReportGenerator(PersonReader reader) {
        this.reader = reader;
    }

    public void generateReport(String file) throws IOException {
        List<Person> persons = reader.readPersons();
        writeReport(persons, file, 0, 30);
        writeReport(persons, file, 30, 50);
        writeReport(persons, file, 50, 120);
    }

    private void writeReport(List<Person> persons, String file, int min, int max) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try (bufferedWriter) {
            persons.stream()
                    .filter(person -> person.getAge() >= min)
                    .filter(person -> person.getAge() <= max)
                    .map(person -> "First Name: " + person.getFirstName() + ",  Last name: " + person.getLastName() + ",   Age: " + person.getAge())
                    .forEach(line -> writeLine(bufferedWriter, line));
        }

    }

    private void writeLine(BufferedWriter bufferedWriter, String line) {

        try {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

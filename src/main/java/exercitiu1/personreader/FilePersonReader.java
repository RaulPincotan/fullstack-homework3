package exercitiu1.personreader;

import exercitiu1.entity.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersonReader implements PersonReader {
    private final String file;

    public FilePersonReader(String file) {
        this.file = file;
    }


    @Override
    public List<Person> readPersons() {
        try {
            return Files.lines(Path.of(file))
                    .map(this::readPerson)//mapac ca sa avem in colectie persoane
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    private Person readPerson(String s) {
        String[] tokens = s.split(",");
        return new Person(tokens[0],
                tokens[1],
                Integer.parseInt(tokens[2]));
    }
}

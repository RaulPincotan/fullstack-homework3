package exercitiu3;

import report.ReportGenerator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        GymService gymService = new GymService
                (List.of(new Membership(new GymMember("Raul", LocalDate.of(1991, Month.JULY, 8)), 25),
                        new Membership(new GymMember("Pincotan", LocalDate.of(1994, Month.JANUARY, 8)), 7),
                        new Membership(new GymMember("Johannis", LocalDate.of(1950, Month.MARCH, 8)), 3),
                        new Membership(new GymMember("Borris Johnson", LocalDate.of(1740, Month.JANUARY, 8)), 17),
                        new Membership(new GymMember("Dorina", LocalDate.of(1964, Month.JANUARY, 8)), 55),
                        new Membership(new GymMember("Radu", LocalDate.of(1964, Month.NOVEMBER, 6)), 132)
                ));

        System.out.println(gymService.getAverageAge());
        System.out.println(gymService.getOldestMember());
        System.out.println(gymService.getYoungestMember());

        gymService.addTime(gymService.getMemberships().get(4), 20);
        System.out.println(gymService.getMemberships());
        System.out.println(gymService.findMembershipByName("Raul"));
        System.out.println(gymService.findMembershipByName("Vadim"));


        LocalDate localDateNow = LocalDate.now();

        ReportGenerator reportGenerator = new ReportGenerator();
        System.out.println(gymService.getMemberships());
        reportGenerator.generateReport("RED", gymService.getMemberships(), "src/main/resources/red-remaining-time-report-" + localDateNow + ".txt", 0, 9);
        reportGenerator.generateReport("YELLOW", gymService.getMemberships(), "src/main/resources/yellow-remaining-time-report-" + localDateNow + ".txt", 10, 29);
        reportGenerator.generateReport("GREEN", gymService.getMemberships(), "src/main/resources/green-remaining-time-report-" + localDateNow + ".txt", 30, Integer.MAX_VALUE);

    }
}

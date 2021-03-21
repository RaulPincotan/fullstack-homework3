package report;

import exercitiu3.Membership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {


    public void generateReport(String status, List<Membership> memberships, String file, int minTime, int maxTime) throws IOException {
        writeReport(file, memberships, status + "- >", minTime, maxTime);

    }

    private void writeReport(String file, List<Membership> memberships, String status, int min, int max) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try (bufferedWriter) {
            memberships
                    .stream()
                    .filter(membership -> membership.getRemainingTime() >= min)
                    .filter(membership -> membership.getRemainingTime() <= max)
                    .map(membership -> status + " -> " + membership.getGymMember() + "|  -> remainaing time: " + membership.getRemainingTime())
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

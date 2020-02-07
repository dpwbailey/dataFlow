import com.opencsv.CSVIterator;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class dataFlow {


    public static ArrayList<String> readCsv(String csvPath) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        String[] line;
        CSVReader csvReader = new CSVReader(new FileReader(csvPath));
        try {
            while (((line = csvReader.readNext()) != null)) {
                for (int i = 0; i < line.length; i++) {
                    lines.add(line[i]);
                }
                lines.add("\n");
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        System.out.println(lines.toString());
        return lines;
    }

    public static void writeCsv(File file) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(Paths.get(String.valueOf(file)));
        CSVWriter csvWriter = new CSVWriter(bw);

    }

    public static void main(String[] args) throws IOException {
        readCsv("src\\SEOExample-1.csv");
    }
}


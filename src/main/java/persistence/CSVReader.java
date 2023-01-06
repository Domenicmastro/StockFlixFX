package persistence;

import model.assets.Ticker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    //EFFECTS: creates the list of companies in the program using symbol lists in data folder
    public static List<Ticker> createTickerList(String fileName) {
        List<Ticker> allTickers = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader stream = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = stream.readLine();

            //skip first line
            line = stream.readLine();

            while (line != null) {
                String [] data = line.split(",");

                Ticker ticker = createTicker(data);
                allTickers.add(ticker);

                line = stream.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return allTickers;
    }

    //EFFECTS: Helper function for createTickerList, creates a company for given line in CSV file.
    public static Ticker createTicker(String[] data) {
        String ticker = data[0];
        String name = data[1];

        return new Ticker(ticker, name);
    }

}

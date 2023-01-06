package persistence;

// Represents a reader that reads user from JSON data stored in file

import model.User;
import model.assets.Asset;
import model.assets.Portfolio;
import model.assets.Watchlist;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    // EFFECTS: reads user from file and returns it;
    // throws IOException if an error occurs reading data from file
    /*public User readUser() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseUser(jsonObject);
    }*/

    // EFFECTS: reads user list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public List<User> readAccountList() throws IOException {
        List<User> accountList = new ArrayList<>();
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);

        JSONArray jsonArray = jsonObject.getJSONArray("users");
        for (Object json : jsonArray) {
            JSONObject nextUser = (JSONObject) json;
            accountList.add(parseUser(nextUser));
        }

        return accountList;
    }


    // EFFECTS: parses user from JSON object and returns it
    private User parseUser(JSONObject jsonObject) {
        String name = jsonObject.getString("userName");
        UUID uuid = UUID.fromString(jsonObject.getString("uuid"));
        String profileImagePath = jsonObject.getString("imagePath");
        Portfolio portfolio = parsePortfolio(jsonObject.getJSONArray("portfolio"));
        Watchlist watchList = parseWatchlist(jsonObject.getJSONArray("watchlist"));

        return new User(name, uuid, profileImagePath, portfolio, watchList);
    }

    // MODIFIES: user
    // EFFECTS: parses companies from JSON object and returns portfolio
    private Portfolio parsePortfolio(JSONArray jsonArray) {
        Portfolio returnPortfolio = new Portfolio();

        for (Object json : jsonArray) {
            JSONObject nextAsset = (JSONObject) json;
            returnPortfolio.addAsset(parseAsset(nextAsset));
        }
        return returnPortfolio;
    }

    // MODIFIES: user
    // EFFECTS: parses companies from JSON object and returns portfolio
    private Watchlist parseWatchlist(JSONArray jsonArray) {
        Watchlist returnWatchlist = new Watchlist();

        for (Object json : jsonArray) {
            JSONObject nextAsset = (JSONObject) json;
            returnWatchlist.addAsset(parseAsset(nextAsset));
        }
        return returnWatchlist;
    }

    // MODIFIES: user
    // EFFECTS: parses Asset from JSON object returns it
    private Asset parseAsset(JSONObject jsonObject) {
        String ticker = jsonObject.getString("ticker");
        String name = jsonObject.getString("name");
        String purchaseDate = jsonObject.getString("purchaseDate");
        String purchaseTime = jsonObject.getString("purchaseTime");
        float purchasePrice = jsonObject.getFloat("purchasePrice");

        return new Asset(ticker, name, purchaseDate, purchaseTime, purchasePrice);
    }
}

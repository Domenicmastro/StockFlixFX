package API;

import model.assets.Address;
import model.assets.DetailedTicker;
import model.assets.Ticker;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static constants.Constants.APIkey;

public class API {

    public static List<Ticker> queryAllStockTickers() {
        List<Ticker> tickerList = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(IOUtils.toString(new URL("https://api.polygon.io/v3/reference/tickers?market=stocks&active=true&apiKey=" + APIkey),
                    Charset.forName("UTF-8")));

            JSONArray jsonArray = json.getJSONArray("results");

            for (Object ticker : jsonArray) {
                JSONObject nextTicker = (JSONObject) ticker;
                tickerList.add(new Ticker(nextTicker.getString("ticker"),
                        nextTicker.getString("name")));
            }
        } catch (Exception e) {
            // something
        }
        return tickerList;
    }

    public static DetailedTicker queryTicker(String ticker) {
        try {
            JSONObject detailsQuery = new JSONObject(IOUtils.toString(
                    new URL("https://api.polygon.io/v3/reference/tickers/" + ticker + "?apiKey=" + APIkey),
                    Charset.forName("UTF-8")));

            JSONObject queryResults = detailsQuery.getJSONObject("results");

            String name = queryResults.getString("name");
            String market = queryResults.getString("market");
            String exchange = queryResults.getString("primary_exchange");
            String type = queryResults.getString("type");
            String currencyName = queryResults.getString("currency_name");
            String phoneNumber = queryResults.getString("phone_number");

            // address helper
            JSONObject JSONaddress = queryResults.getJSONObject("address");
            Address address = new Address(
                    JSONaddress.getString("address1"),
                    JSONaddress.getString("city"),
                    JSONaddress.getString("state"),
                    JSONaddress.getString("postal_code"));

            // branding helper
            JSONObject JSONBranding = queryResults.getJSONObject("branding");
            String logoURL = JSONBranding.getString("logo_url");
            URL authLogoURL = new URL(logoURL + "?apiKey=" + APIkey);
            Image logo = ImageIO.read(authLogoURL);
            // logo coming out null

            String description = queryResults.getString("description");
            String url = queryResults.getString("homepage_url");


            int employees = queryResults.getInt("total_employees");
            long marketCap = queryResults.getLong("market_cap");

            JSONObject prevCloseQuery = new JSONObject(IOUtils.toString(
                    new URL("https://api.polygon.io/v2/aggs/ticker/" + ticker + "/prev?adjusted=true&apiKey=" + APIkey),
                    Charset.forName("UTF-8")));
            JSONArray prevCloseResults = prevCloseQuery.getJSONArray("results");
            JSONObject prevCloseResultsObject = prevCloseResults.getJSONObject(0);

            float close = prevCloseResultsObject.getFloat("c");
            float high = prevCloseResultsObject.getFloat("h");
            float low = prevCloseResultsObject.getFloat("l");
            float open = prevCloseResultsObject.getFloat("o");
            long volume = prevCloseResultsObject.getLong("v");

            return new DetailedTicker(ticker, name, market, exchange, type, currencyName, phoneNumber, address, description, url, logo, employees, marketCap, close, high, low, open, volume);
        } catch (Exception e) {
            // something
        }
        return null;
    }

}

package model.assets;

import java.awt.*;

// More complete data on a ticker, designed to be retrieved from Polygon.io
public class DetailedTicker extends Ticker {
    private String market;
    private String exchange;
    private String type;
    private String currencyName;
    private String phoneNumber;
    private Address address;
    private String description;
    private String url;
    private Image logo;

    // daily open/close?

    private int employees;
    private long marketCap;

    private float close;
    private float high;
    private float low;
    private float open;
    private long volume;

    public DetailedTicker(String ticker,
                          String name,
                          String market,
                          String exchange,
                          String type,
                          String currencyName,
                          String phoneNumber,
                          Address address,
                          String description,
                          String url,
                          Image logo,
                          int employees,
                          long marketCap,
                          float close,
                          float high,
                          float low,
                          float open,
                          long volume) {
        super(ticker, name);
        this.market = market;
        this.exchange = exchange;
        this.type = type;
        this.currencyName = currencyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
        this.url = url;
        this.logo = logo;
        this.employees = employees;
        this.marketCap = marketCap;
        this.close = close;
        this.high = high;
        this.low = low;
        this.open = open;
        this.volume = volume;
    }
}

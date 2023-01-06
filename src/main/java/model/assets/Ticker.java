package model.assets;

public class Ticker {
    private String ticker;
    private String name;

    public Ticker(String ticker, String name) {
        this.ticker = ticker;
        this.name = name;
    }

    public String getTicker() {
        return this.ticker;
    }

    public String getName() {
        return this.name;
    }
}

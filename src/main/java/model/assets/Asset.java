package model.assets;

public class Asset implements Tradable {

    private String ticker;
    private String name;
    private String purchaseDate;
    private String purchaseTime;
    private float purchasePrice;

    public Asset(String ticker, String name, String purchaseDate, String purchaseTime, float purchasePrice) {
        this.ticker = ticker;
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.purchasePrice = purchasePrice;
    }


}

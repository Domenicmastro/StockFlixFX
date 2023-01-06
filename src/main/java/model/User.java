package model;

import model.assets.Portfolio;
import model.assets.Watchlist;

import java.util.UUID;



// a class representing a User
public class User {
    private String userName;
    private UUID uuid;
    private String profileImagePath;
    private Portfolio portfolio;
    private Watchlist watchList;


    // Constructor for creating user from scratch
    public User(String userName) {
        this.userName = userName;
        uuid = UUID.randomUUID();
        portfolio = new Portfolio();
        watchList = new Watchlist();
    }

    // Constructor for recreating user from JSON
    public User(String userName, UUID uuid, String profileImagePath, Portfolio portfolio, Watchlist watchList) {
        this.userName = userName;
        this.uuid = uuid;
        this.profileImagePath = profileImagePath;
        this.portfolio = portfolio;
        this.watchList = watchList;
    }

    public String getUserName() {
        return userName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public Watchlist getWatchList() {
        return watchList;
    }

}

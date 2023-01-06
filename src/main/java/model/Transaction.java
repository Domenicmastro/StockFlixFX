package model;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;


    // Creates a transaction with the given description and the current date/time stamp
    public Transaction(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }


    public Date getDate() {
        return dateLogged;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Transaction otherTransaction = (Transaction) other;

        return (this.dateLogged.equals(otherTransaction.dateLogged)
                && this.description.equals(otherTransaction.description));
    }

    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}

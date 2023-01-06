package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// a singleton class for logging
public class TransactionLog implements Iterable<Transaction> {

    public static TransactionLog transactionLog = new TransactionLog();
    private Collection<Transaction> transactions;

    private TransactionLog() {
        transactions = new ArrayList<>();
    }

    public static TransactionLog getInstance() {
        return transactionLog;
    }

    private void logTransaction(Transaction t) {
        transactions.add(t);
    }

    @Override
    public Iterator<Transaction> iterator() {
        return transactions.iterator();
    }
}

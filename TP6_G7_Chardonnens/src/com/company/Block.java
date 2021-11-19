package com.company;

import java.util.ArrayDeque;

public class Block {
    private ArrayDeque<Transaction> transactions = new ArrayDeque<>();

    public Block add(Transaction transaction) {
        transactions.add(transaction);
        if (transactions.size() == 10) {
            
        }
        return this;
    }
}

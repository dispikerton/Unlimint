package com.ivanov.unlimint.test_task.entity;

import com.ivanov.unlimint.test_task.enums.CorrectEntry;

import java.util.Currency;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {

    public static AtomicInteger ai = new AtomicInteger(1);

    private int orderId;
    private double amount;
    private Currency currency;
    private String comment;
    private String filename;
    private int line;
    private CorrectEntry correctEntry;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public CorrectEntry getCorrectEntry() {
        return correctEntry;
    }

    public void setCorrectEntry(CorrectEntry correctEntry) {
        this.correctEntry = correctEntry;
    }

    @Override
    public String toString() {
        String formattedAmount = fmt(amount);

        return "{" +
                "\"id\":" + orderId +
                ", \"amount\":" + formattedAmount +
                ", \"comment\":\"" + comment  + "\"" +
                ", \"filename\":\"" + filename  + "\"" +
                ", \"line\":" + line +
                ", \"result\":\"" + correctEntry + "\"" +
                '}';
    }

    public static String fmt(double d) {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
}

package com.ivanov.unlimint.test_task.parsers;

import com.ivanov.unlimint.test_task.entity.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class Parser {
    private final CSV csv;
    private final JSON json;

    public Parser(CSV csv, JSON json) {
        this.csv = csv;
        this.json = json;
    }

    public void parse(String[] files) {
        for (String fileName : files){
            Thread thread = new Thread(() -> {
                List<Order> orders = new ArrayList<>();
                if (fileName.endsWith(".csv"))
                    orders = csv.parse(new File(fileName));
                else if (fileName.endsWith(".json"))
                    orders = json.parse(new File(fileName));
                for (Order order : orders)
                    System.out.println(order);
            });
            thread.start();
        }
    }
}


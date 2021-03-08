package com.ivanov.unlimint.test_task.csv_parser;

import com.ivanov.unlimint.test_task.enums.CorrectEntry;
import com.ivanov.unlimint.test_task.enums.Currency;
import com.ivanov.unlimint.test_task.entity.Order;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public List<Order> parse(File file) {
        List<Order> orders = new ArrayList<>();


        Order parsedOrder;
        int line = 1;

        try {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .parse(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));

            for (CSVRecord record : records) {
                parsedOrder = new Order();
                parsedOrder.setOrderId(Order.ai.getAndIncrement());
                parsedOrder.setAmount(Double.parseDouble(record.get(1)));
                parsedOrder.setCurrency(Currency.valueOf(record.get(2)));
                parsedOrder.setComment(record.get(3));
                parsedOrder.setFilename(file.getName());
                parsedOrder.setLine(line);
                parsedOrder.setCorrectEntry(CorrectEntry.OK);
                orders.add(parsedOrder);
                line++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }
}

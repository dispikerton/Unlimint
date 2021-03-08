package com.ivanov.unlimint.test_task.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanov.unlimint.test_task.entity.Order;
import com.ivanov.unlimint.test_task.enums.CorrectEntry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSON {

    public List<Order> parse(File file) {
        List<Order> orders = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        int line = 1;

        try {
            orders = mapper.readValue(file,  new TypeReference<List<Order>>(){});
            for (Order order : orders) {
                order.setOrderId(Order.ai.getAndIncrement());
                order.setFilename(file.getName());
                order.setLine(line);
                order.setCorrectEntry(CorrectEntry.OK);
                line++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }
}

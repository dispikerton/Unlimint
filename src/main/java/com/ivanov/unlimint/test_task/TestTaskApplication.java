package com.ivanov.unlimint.test_task;

import com.ivanov.unlimint.test_task.parsers.CSV;
import com.ivanov.unlimint.test_task.parsers.JSON;
import com.ivanov.unlimint.test_task.entity.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class TestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);

        for (String fileName : args){
            if (fileName.endsWith(".csv")){
                Thread thread = new Thread(() -> {
                    CSV csv = new CSV();
                    List<Order> orderCSDV = csv.parse(new File(fileName));
                    for (Order order : orderCSDV)
                        System.out.println(order);
                });
                thread.start();
            }
            else if (fileName.endsWith(".json")){
                Thread thread2 = new Thread(() -> {
                    JSON json = new JSON();
                    List<Order> ordersJSON = json.parse(new File(fileName));
                    for (Order order : ordersJSON)
                        System.out.println(order);
                });
                thread2.start();
            }
        }








    }

}

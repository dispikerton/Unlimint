package com.ivanov.unlimint.test_task;

import com.ivanov.unlimint.test_task.parsers.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);

        String[] files = new String[]{"sample.txt"};

        Parser parser = new Parser();
        parser.parse(files);
    }
}

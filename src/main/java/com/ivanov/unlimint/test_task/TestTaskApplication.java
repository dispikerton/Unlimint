package com.ivanov.unlimint.test_task;

import com.ivanov.unlimint.test_task.parsers.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class TestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);

        ApplicationContext javaConfigContext =
                new AnnotationConfigApplicationContext(Config.class);
        Parser parser = javaConfigContext.getBean(Parser.class);
        parser.parse(args);


    }
}

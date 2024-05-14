package com.smartcat.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;
import java.util.stream.Collectors;

@ComponentScan(basePackages = {"com.smartcat"})
@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        //注释
        for (String item : list) {
            list.remove(item);
        }
        // hello
        for (String item : list) {
            list.remove(item);
        }

        list.stream().map(item -> {
            System.out.println(item);
            return item;
        }).collect(Collectors.toList());
        SpringApplication.run(StarterApplication.class, args);
    }

}


package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/dz")
    public String hello(@RequestParam(value = "x",defaultValue = " Пусто Пусто ") String x) {
        if(x.equals(" Пусто Пусто ")) return x;
        char[] xxx = x.toCharArray();
        if (xxx.length==1) return x;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i <xxx.length ; i++) {
            if(map.get( xxx[i])==null)
                map.put( xxx[i],1);
            else map.put(xxx[i], map.get(xxx[i])+1);
        }
        for (int i = 0; i <xxx.length ; i++) {
            if (map.get(xxx[i])==1)
                return String.valueOf(xxx[i]);
        }

        return "Все символы повторяются";
    }


}
            
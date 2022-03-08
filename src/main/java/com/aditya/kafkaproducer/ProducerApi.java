package com.aditya.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProducerApi {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name){
        kafkaTemplate.send("aditya","HI"+name);
        return "Data Published";
    }

    @GetMapping("/publishjson")
    public String publishMessage(){
        User user = new User("1","Aditya","RJN");
        kafkaTemplate.send("aditya",user);
        return "JSON Data Published";
    }
}

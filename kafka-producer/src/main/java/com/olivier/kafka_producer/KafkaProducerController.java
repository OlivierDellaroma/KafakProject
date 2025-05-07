package com.olivier.kafka_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Date;

@RestController
@RequestMapping(value ="/producer")
public class KafkaProducerController {

    @Value(value= "${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String produce(@RequestBody String string){
        String message = new Date() + " : "+ string.toString();
        kafkaTemplate.send(topic,message);
        return message;
    }
}

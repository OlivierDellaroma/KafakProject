package com.olivier.kafka_consumer;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Service
public class ConsumerService {

    @Value(value = "${kafka.bootstrap-server}")
    private String bootstrapServer;

    @Value(value = "${kafka.group-id}")
    private String groupId;

    @Value(value = "${kafka.topic}")
    private String topic;

    @Value(value = "${kafka.offset}")
    private String offset;

    private Properties properties;
    private KafkaConsumer<String,String> consumer;

    @PostConstruct
    public void setup(){
        properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offset);

        topic ="kafka-formation";
        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(topic));
    }

    @Scheduled(fixedRate = 5000)
    public void process(){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(100));
            records.forEach(stringStringConsumerRecord -> System.out.println(stringStringConsumerRecord.value()));
    }
}

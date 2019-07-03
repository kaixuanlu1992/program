package com.work.base.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args){
        sendMessage1();

    }
    public static void sendMessage1(){
        Properties kafkaProp=new Properties();
        kafkaProp.put("bootstrap.servers", "120.79.91.4:9092");
        kafkaProp.put("key.serializer","org.apache.kafka.biz.serialization.StringSerializer");
        kafkaProp.put("value.serializer","org.apache.kafka.biz.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer <String, String>(kafkaProp);
        ProducerRecord<String, String> record=new ProducerRecord<String, String>("test", "products", "france");
        try{
            producer.send(record).get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

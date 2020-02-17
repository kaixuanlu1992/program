//package com.work.base.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//
//import java.util.Collections;
//import java.util.Properties;
//
//public class Consumer {
//    public static void main(String[] args){
//        Properties kafkaProp=new Properties();
//        kafkaProp.put("bootstrap.servers", "120.79.91.4:9092");
//        kafkaProp.put("key.deserializer","org.apache.kafka.biz.serialization.StringDeserializer");
//        kafkaProp.put("value.deserializer","org.apache.kafka.biz.serialization.StringDeserializer");
//        kafkaProp.put("group.id","CountryCounter");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer <String, String>(kafkaProp);
//        consumer.subscribe(Collections.singletonList("test"));
//        try{
//            while (true){
//                ConsumerRecords<String,String>records=consumer.poll(100);
//                for (ConsumerRecord<String,String> record:records){
//                    System.out.println(record.value());
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}

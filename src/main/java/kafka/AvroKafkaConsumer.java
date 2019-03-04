//package kafka;
//
//import com.twitter.bijection.Injection;
//import com.twitter.bijection.avro.GenericAvroCodecs;
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Collections;
//import java.util.Properties;
//
///**
// * Created by https://www.iteblog.com on 2017-09-20.
// */
//public class AvroKafkaConsumer {
//    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger("AvroKafkaConsumer");
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "www.iteblog.com:2181");
//        props.put("group.id", "testgroup");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
//        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props);
//        String topic = "iteblog";
//
//        consumer.subscribe(Collections.singletonList(topic));
//        Schema.Parser parser = new Schema.Parser();
//        Schema schema = parser.parse(AvroKafkaProducter.USER_SCHEMA);
//        Injection<GenericRecord, byte[]> recordInjection = GenericAvroCodecs.toBinary(schema);
//
//        try {
//            while (true) {
//                ConsumerRecords<String, byte[]> records = consumer.poll(1000);
//                for (ConsumerRecord<String, byte[]> record : records) {
//                    GenericRecord genericRecord = recordInjection.invert(record.value()).get();
//                    logger.info("topic = %s, partition = %s, offset = %d, customer = %s,country = %s\n, record.topic(), record.partition(), record.offset(), "  +
//                            "record.key(), genericRecord.get("str1"));
//                }
//            }
//        } finally {
//            consumer.close();
//        }
//    }
//}}
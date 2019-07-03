package com.work.base.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyConsumer {
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "120.79.91.4";
    private static final int PORT = 5672;
    
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses=new Address[]{new Address(IP_ADDRESS,PORT)};
        ConnectionFactory factory=new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("123456");
        Connection connection=factory.newConnection(addresses);
        final Channel channel=connection.createChannel();
        channel.basicQos(64);
        Consumer consume=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message:"+new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };

        channel.basicConsume(QUEUE_NAME,consume);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();





    }
}

package com.example.rabbitmqdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 *
 * @date:2023/8/23 14:02
 * @author: ilpvc
 */
@SpringBootTest()
public class SpringAmqpTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() throws InterruptedException {
        String name = "queue";
        String message = "hello,我现在发送的是";
        for (int i=1;i<=100;i++){
            rabbitTemplate.convertAndSend(name,message+i);
            Thread.sleep(100);
        }

    }
}

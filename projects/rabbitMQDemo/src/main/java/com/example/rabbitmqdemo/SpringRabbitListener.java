package com.example.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @date:2023/8/23 14:20
 * @author: ilpvc
 */
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "queue")
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        System.out.println("监听者1："+msg);
        Thread.sleep(300);
    }
}

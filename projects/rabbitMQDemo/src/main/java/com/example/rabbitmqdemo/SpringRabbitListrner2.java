package com.example.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @date:2023/8/23 14:24
 * @author: ilpvc
 */
@Component
public class SpringRabbitListrner2 {

    @RabbitListener(queues = "queue")
    public void listenSimpleQueueMessage(String msg){
        System.out.println("监听者2："+msg);
    }
}

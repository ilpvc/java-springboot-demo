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

    @Test
    public void testFanoutExchange(){
        String exchangeName = "itcast.fanout";
        String message = "hello,everyone";
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }


    @Test
    public void testDirectExchange() {
        // 队列名称
        String exchangeName = "itcast.direct";
        // 消息
        String message = "红色警报！日本乱排核废水，导致海洋生物变异，惊现哥斯拉！";
        // 发送消息，参数依次为：交换机名称，RoutingKey，消息
        rabbitTemplate.convertAndSend(exchangeName, "red", message);

        String m1="今天天气很好，很适合出去玩";
        String m2 = "几天是黄色天气不谁和出门";
        rabbitTemplate.convertAndSend(exchangeName,"blue",m1);
        rabbitTemplate.convertAndSend(exchangeName,"yellow",m2);

    }

    @Test
    public void testTopicExchange() {
        // 队列名称
        String exchangeName = "itcast.topic";
        // 消息
        String message = "喜报！孙悟空大战哥斯拉，胜!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "china.news", message);
        rabbitTemplate.convertAndSend(exchangeName, "china.ceshi", "中国的一条测试，只有中国能收到");
        rabbitTemplate.convertAndSend(exchangeName, "ceshi.news", "一条不知道哪里的新闻");
    }

}

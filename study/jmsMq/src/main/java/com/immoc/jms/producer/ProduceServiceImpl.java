package com.immoc.jms.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-19
 */
@Service
public class ProduceServiceImpl implements ProduceService {

    @Resource
    private JmsTemplate jmsTemplate;

    //主题模式
    // @Resource(name = "topicDestination")
    // private Destination destination;

    // 队列模式
    @Resource(name = "queueDestination")
    private Destination destination;

    @Override
    public void sendMessage(String message) {
        // 使用jmsTemplate发送消息
        jmsTemplate.send(destination, session -> {
            // 创建一个消息
            return session.createTextMessage(message);
        });
        System.out.println("发送消息:" + message);

    }
}

package com.immoc.jms.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author yugi
 * @apiNote 这个要用xml配置DefaultJmsListenerContainerFactory, 不用实现MessageListener
 * @since 2017-07-19
 */
@Component
public class ConsumerMessageListener {

    // 队列模式
    @JmsListener(destination = "myQueue")
    // 主题模式
    // @JmsListener(destination = "myTopic")
    public void receiveMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接收消息:" + textMessage.getText());
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

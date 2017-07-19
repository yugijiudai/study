package com.immoc.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author yugi
 * @apiNote 这个要用xml配置DefaultMessageListenerContainer, 并且实现MessageListener
 * @since 2017-07-19
 */
public class ConsumerMessageListenerXml implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("xml接收消息:" + textMessage.getText());
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
    }
}




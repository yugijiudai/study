package com.immoc.activemq.queues;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author yugi
 * @apiNote 消息监听
 * @since 2017-07-17
 */
public class JMSListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("收到的消息:" + ((TextMessage) message).getText());
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

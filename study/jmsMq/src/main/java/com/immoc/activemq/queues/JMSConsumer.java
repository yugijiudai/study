package com.immoc.activemq.queues;

import com.immoc.activemq.constants.JMSConstant;
import com.immoc.activemq.util.JMSUtil;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author yugi
 * @apiNote 消息消费者
 * @since 2017-07-17
 */
public class JMSConsumer {

    public static final String URL = "failover:(tcp://localhost:61616,tcp://localhost:61617,tcp://localhost:61618)?randomize=true";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = JMSUtil.getJMSConnection(URL);
            // 不加事务
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 创建连接的消息队列,这个名称要和生产者一样
            Destination destination = session.createQueue(JMSConstant.QUEUE_NAME);
            // 消息的消费者
            MessageConsumer messageConsumer = session.createConsumer(destination);
            // consumer(messageConsumer);
            //
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println("收到的消息:" + ((TextMessage) message).getText());
                    }
                    catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
            // 不能关闭连接!!!!不然无法接收
            JMSUtil.closeConnection(connection);
        }
    }

    //这种方式不好
    private static void consumer(MessageConsumer messageConsumer) {
        while (true) {
            TextMessage message;
            try {
                message = (TextMessage) messageConsumer.receive(10000 * 10);
                if (message == null) {
                    break;
                }
                System.out.println("收到消息:" + message.getText());
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}

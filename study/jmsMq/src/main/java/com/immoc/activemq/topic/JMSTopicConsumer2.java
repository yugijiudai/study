package com.immoc.activemq.topic;

import com.immoc.activemq.constants.JMSConstant;
import com.immoc.activemq.util.JMSUtil;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author yugi
 * @apiNote 消息订阅者2
 * @since 2017-07-17
 */
public class JMSTopicConsumer2 {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = JMSUtil.getJMSConnection();
            // 不加事务
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 创建连接的消息队列,这个名称要和生产者一样
            Destination destination = session.createTopic(JMSConstant.TOPIC_NAME);
            // 消息的消费者
            MessageConsumer messageConsumer = session.createConsumer(destination);
            //关闭连接!!!!不然无法接收
            messageConsumer.setMessageListener(message -> {
                try {
                    System.out.println("订阅者2收到的消息:" + ((TextMessage) message).getText());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
            JMSUtil.closeConnection(connection);
        }
    }


}

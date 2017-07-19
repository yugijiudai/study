package com.immoc.activemq.topic;

import com.immoc.activemq.constants.JMSConstant;
import com.immoc.activemq.util.JMSUtil;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author yugi
 * @apiNote 消息发布者
 * @since 2017-07-17
 */
public class JMSTopicProducer {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = JMSUtil.getJMSConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(JMSConstant.TOPIC_NAME);
            MessageProducer messageProducer = session.createProducer(destination);
            sendMessage(session, messageProducer);
            session.commit();
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
        finally {
            JMSUtil.closeConnection(connection);
        }
    }

    private static void sendMessage(Session session, MessageProducer messageProducer) {
        for (int i = 0; i < JMSUtil.SEND_NUM; i++) {
            try {
                TextMessage message = session.createTextMessage("hello world:" + i);
                System.out.println("发布的消息-" + message.getText());
                messageProducer.send(message);
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

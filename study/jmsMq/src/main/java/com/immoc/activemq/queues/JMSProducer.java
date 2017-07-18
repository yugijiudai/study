package com.immoc.activemq.queues;

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
 * @apiNote 消息生产者
 * @since 2017-07-17
 */
public class JMSProducer {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = JMSUtil.getJMSConnection();
            // 会话接收或者发送信息的线程,true是添加事务
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // 创建消息队列,消息的目的地
            Destination destination = session.createQueue(JMSConstant.QUEUE_NAME);
            // 创建消息生产者
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
                System.out.println("发送消息--hello world:" + i);
                messageProducer.send(message);
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

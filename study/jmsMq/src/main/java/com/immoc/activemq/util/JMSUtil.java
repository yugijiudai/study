package com.immoc.activemq.util;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 * @author yugi
 * @apiNote http://localhost:8161/admin/queues.jsp
 * @since 2017-07-17
 */
public class JMSUtil {

    public static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;

    public static final String PASS = ActiveMQConnection.DEFAULT_PASSWORD;

    // public static final String URL = "failover:(tcp://localhost:61617,tcp://localhost:61618)?randomize=true";
    public static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    // 发送消息的数量
    public static final int SEND_NUM = 100;

    public static Connection getJMSConnection(String url) {
        // 实例化连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        // ConnectionFactory factory = new ActiveMQConnectionFactory(USER_NAME, PASS, url);
        Connection connection = null;
        try {
            connection = factory.createConnection();
            // 启动连接
            connection.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

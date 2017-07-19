package com.immoc.jms.consumer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-19
 */
public class AppConsumer {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("consumer.xml");
    }
}

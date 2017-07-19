package com.immoc.jms.producer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-19
 */
public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProduceService service = context.getBean(ProduceService.class);
        for (int i = 0; i < 100; i++) {
            service.sendMessage("test" + i);
        }
        context.close();
    }
}

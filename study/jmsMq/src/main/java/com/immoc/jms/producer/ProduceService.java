package com.immoc.jms.producer;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-19
 */
public interface ProduceService {

    void sendMessage(String message);
}

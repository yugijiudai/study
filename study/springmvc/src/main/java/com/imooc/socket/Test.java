package com.imooc.socket;

import lombok.extern.log4j.Log4j2;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author 九风萍舟
 * @Class: Test
 * @Description: 简单websocket demo
 */
@Log4j2
@ServerEndpoint(value = "/websocketTest/{userId}")
public class Test {

    private static String userId;

    //连接时执行
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {
        this.userId = userId;
        log.info("新连接：{}", userId);
    }

    //关闭时执行
    @OnClose
    public void onClose() {
        log.info("连接：{} 关闭", this.userId);
    }

    //收到消息时执行
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("收到用户{}的消息{}", this.userId, message);
        session.getBasicRemote().sendText("收到 " + this.userId + " 的消息 "); //回复用户
    }

    //连接错误时执行
    @OnError
    public void onError(Session session, Throwable error) {
        log.info("用户id为：{}的连接发送错误", this.userId);
        error.printStackTrace();
    }

}


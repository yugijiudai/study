package com.imooc.service;

import com.imooc.socket.WebsocketDemo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Log4j2
@Service("webSocketMessageService")
public class WSMessageService {

    //声明websocket连接类
    private WebsocketDemo websocketDemo = new WebsocketDemo();


    /**
     * 调用websocket类给用户下的所有终端发送消息
     *
     * @param userId  userId 用户id
     * @param message message 消息
     * @return 发送成功返回true，否则返回false
     */
    public Boolean sendToAllTerminal(Long userId, String message) {
        log.debug("向用户{}的消息：{}", userId, message);
        return websocketDemo.sendMessageToUser(userId, message);
    }
}


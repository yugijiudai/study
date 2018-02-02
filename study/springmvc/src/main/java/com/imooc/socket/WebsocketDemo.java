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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhonghaowen
 * @apiNote websocket连接URL地址和可被调用配置
 * @since 2018-02-02
 */
@Log4j2
@ServerEndpoint(value = "/websocketDemo/{userId}")
// @ServerEndpoint(value = "/websocketDemo/{userId}", configurator = SpringConfigurator.class)
public class WebsocketDemo {

    private static AtomicInteger onlineCount = new AtomicInteger(0);

    //记录每个用户下多个终端的连接
    private static Map<Long, Set<WebsocketDemo>> userSocket = new ConcurrentHashMap<>();

    //需要session来对用户发送数据, 获取连接特征userId
    private Session session;

    private Long userId;

    /**
     * websocket连接建立时的操作
     *
     * @param userId  用户id
     * @param session websocket连接的session属性
     */
    @OnOpen
    public void onOpen(@PathParam("userId") Long userId, Session session) throws IOException {
        this.session = session;
        this.userId = userId;
        Set<WebsocketDemo> user = userSocket.get(userId);
        //根据该用户当前是否已经在别的终端登录进行添加操作
        if (user != null) {
            log.info("当前用户id:{}已有其他终端登录", userId);
            user.add(this); //增加该用户set中的连接实例
        }
        else {
            onlineCount.incrementAndGet();
            log.info("当前用户id:{}第一个终端登录", userId);
            Set<WebsocketDemo> addUserSet = new HashSet<>();
            addUserSet.add(this);
            userSocket.put(userId, addUserSet);
        }
        log.info("用户{}登录的终端个数是为{}", userId, userSocket.get(userId).size());
        log.info("当前在线用户数为：{},所有终端个数为：{}", userSocket.size(), onlineCount);
    }

    /**
     * 连接关闭的操作
     */
    @OnClose
    public void onClose() {
        //移除当前用户终端登录的websocket信息,如果该用户的所有终端都下线了，则删除该用户的记录
        if (userSocket.get(this.userId).size() == 0) {
            userSocket.remove(this.userId);
        }
        else {
            userSocket.get(this.userId).remove(this);
        }
        onlineCount.decrementAndGet();
        log.info("用户{}登录的终端个数是为{}", this.userId, userSocket.get(this.userId).size());
        log.info("当前在线用户数为：{}", onlineCount);
    }

    /**
     * 收到消息后的操作
     *
     * @param message 收到的消息
     * @param session 该连接的session属性
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自用户id为：{}的消息：{}", this.userId, message);
        if (session == null) {
            log.info("session null");
        }
    }

    /**
     * 连接发生错误时候的操作
     *
     * @param session 该连接的session
     * @param error   发生的错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.info("用户id为：{}的连接发送错误", this.userId);
        log.error(error);
    }


    /**
     * 发送消息给用户下的所有终端
     *
     * @param userId  用户id
     * @param message 发送的消息
     * @return 发送成功返回true，反则返回false
     */
    public Boolean sendMessageToUser(Long userId, String message) {
        if (userSocket.containsKey(userId)) {
            log.info(" 给用户id为：{}的所有终端发送消息：{}", userId, message);
            for (WebsocketDemo WS : userSocket.get(userId)) {
                log.info("sessionId为:{}", WS.session.getId());
                try {
                    WS.session.getBasicRemote().sendText(message);
                }
                catch (IOException e) {
                    e.printStackTrace();
                    log.error(" 给用户id为：{}发送消息失败", userId);
                    return false;
                }
            }
            return true;
        }
        log.warn("发送错误：当前连接不包含id为：{}的用户", userId);
        return false;
    }

}


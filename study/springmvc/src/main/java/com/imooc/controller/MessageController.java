package com.imooc.controller;

import com.imooc.service.WSMessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/message")
@Log4j2
public class MessageController {

    @Resource
    private WSMessageService wsMessageService;

    //请求入口
    @RequestMapping(value = "/testWS", method = RequestMethod.GET)
    @ResponseBody
    public String testWS(@RequestParam(value = "userId") Long userId, @RequestParam(value = "message") String message) {
        log.info("收到发送请求，向用户{}的消息：{}", userId, message);
        if (wsMessageService.sendToAllTerminal(userId, message)) {
            return "发送成功";
        }
        return "发送失败";
    }

}

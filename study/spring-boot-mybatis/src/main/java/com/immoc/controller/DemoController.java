package com.immoc.controller;

import com.github.pagehelper.PageHelper;
import com.immoc.pojo.Demo;
import com.immoc.service.DemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-12
 */
@RestController
@Log4j2
public class DemoController {

    @Resource
    private DemoService demoService;


    @GetMapping(value = "/getDemo/{name}")
    //cache的value就是放在redis的key,自己定义,加了这个注解的方法,如果缓存里有这个数据,则直接读缓存放回,这个方法的所有内容都不会被执行
    // @Cacheable(value = "demo-key")
    public List<Demo> getDemo(@PathVariable("name") String name) {
        //第一个参数:第几页,第二个参数：每页获取多少条
        PageHelper.startPage(1, 2);
        log.warn("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return demoService.getByName(name);
    }

    @PostMapping(value = "/saveDemo")
    public Demo saveDemo(Demo demo) {
        demoService.saveDemo(demo);
        return demo;
    }

    @GetMapping("/getUid")
    public String getUid(HttpSession session) {
        //由于配置了SessionConfig,所以session也会存到redism里
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @GetMapping(value = "/getDemo")
    public Demo getDemo() {
        return new Demo().setCreateTime(new Date()).setName("");
    }
}

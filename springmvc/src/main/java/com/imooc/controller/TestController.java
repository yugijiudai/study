package com.imooc.controller;

import com.imooc.entity.Admin;
import com.imooc.entity.DateForm;
import com.imooc.entity.SpringUser;
import com.imooc.entity.SpringUserListForm;
import com.imooc.entity.SpringUserMapForm;
import com.imooc.entity.SpringUserSetForm;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author yugi
 * @apiNote http://www.imooc.com/learn/558
 * @since 2017-06-21
 */
@Controller
public class TestController {


    @ResponseBody
    @RequestMapping(value = "baseType.do")
    public String baseType(@RequestParam(value = "age") int age) {
        return "age:" + age;
    }

    @ResponseBody
    @RequestMapping(value = "array.do")
    public String array(String[] name) {
        StringBuilder sb = new StringBuilder();
        for (String n : name) {
            sb.append(n).append(" ");
        }
        return sb.toString();
    }

    // http://localhost:8080/object.do?admin.name=Tom&admin.age=10&contactInfo.phone=10086&user.name=Jack
    // 在下面的InitBinder绑定了
    @ResponseBody
    @RequestMapping(value = "object.do")
    public String object(SpringUser springUser, Admin admin) {
        return springUser.toString() + "   " + admin.toString();
    }

    // http://localhost:8080/list.do?users[0].name=Tom&users[1].name=fuxkyou
    // http://localhost:8080/list.do?users[0].name=Tom&users[200].name=fuxkyou 小心这种,中间会有一堆空的
    @ResponseBody
    @RequestMapping(value = "list.do")
    public String list(SpringUserListForm springUserListForm) {
        return springUserListForm.toString();
    }

    @ResponseBody
    @RequestMapping(value = "set.do")
    public String set(SpringUserSetForm springUserSetForm) {
        return springUserSetForm.toString();
    }

    // http://localhost:8080/map.do?users['x'].name=Tom&users['x'].age=10&users['x2'].name=fuxk&users['x2'].contactInfo.phone=10086
    @ResponseBody
    @RequestMapping(value = "map.do")
    public String map(SpringUserMapForm springUserMapForm) {
        return springUserMapForm.toString();
    }


    /**
     * <pre>{@code
     *  {
     *      "name" : "jim",
     *      "age": 16,
     *      "contactInfo": {
     *          "phone" : "3232"
     *      }
     * }
     * }
     * </pre>
     */
    @ResponseBody
    @RequestMapping(value = "json.do")
    public String json(@RequestBody SpringUser springUser) {
        return springUser.toString();
    }


    /**
     * <pre>{@code
     *  <?xml version="1.0" encoding="UTF-8" ?>
     *    <admin>
     *      <name>中文</name>
     *      <age>12</age>
     *    </admin>
     * }
     * </pre>
     */
    @ResponseBody
    @RequestMapping(value = "xml.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Admin xml(@RequestBody Admin admin) {
        return admin;
    }


    @ResponseBody
    @RequestMapping(value = "date1.do")
    public String date1(Date date1) {
        return date1.toString();
    }

    @ResponseBody
    @RequestMapping(value = "date2.do")
    public String date2(Date date1, Date date2) {
        return date1.toString() + date2.toString();
    }

    // http://localhost:8080/date3.do?localDate=2011-06-04&localTime=23:10:10&localDateTime=2016-06-04t23:10:10
    // 要传这种特殊时间类型要用对象来传,不能直接用LocalDate做参数
    @ResponseBody
    @RequestMapping(value = "date3.do")
    public String date3(DateForm dateForm) {
        return dateForm.toString();
    }


    @ResponseBody
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String book(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return "book.default";
        }
        else if (contentType.equals("txt")) {
            return "book.txt";
        }
        else if (contentType.equals("html")) {
            return "book.html";
        }
        return "book.default";
    }


    @ResponseBody
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET)
    public String subjectGet(@PathVariable String subjectId) {
        return "this is a get method,subjectId:" + subjectId;
    }

    @ResponseBody
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.POST)
    public String subjectPost(@PathVariable String subjectId) {
        return "this is a post method,subjectId:" + subjectId;
    }

    @ResponseBody
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.DELETE)
    public String subjectDelete(@PathVariable String subjectId) {
        return "this is a delete method,subjectId:" + subjectId;
    }

    @ResponseBody
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.PUT)
    public String subjectPut(@PathVariable String subjectId) {
        return "this is a put method,subjectId:" + subjectId;
    }


    @InitBinder("springUser")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }

    // 这个只能用于局部绑定
    // @InitBinder("date1")
    // public void initDate1(WebDataBinder binder) {
    //     binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    // }

}

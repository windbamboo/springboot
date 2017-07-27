
package com.weituitu.demo04.controller;

import com.weituitu.demo04.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;


/**
 * spring-boot-demo-2-1
 *
 * @author wujing
 */
@RestController
public class IndexController {

    private static Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Value(value = "${weituitu.secret}")
    private String secret;

    @Value(value = "${weituitu.number}")
    private int number;

    @Value(value = "${weituitu.desc}")
    private String desc;

    @RequestMapping(value = "home")
    public String home() {
        LOG.info("#info " + secret);
        LOG.warn("#warn " + secret);
        LOG.error("#error " + secret + "");
        System.out.println(secret);
        System.out.println(number);
        System.out.println(desc);

        return "Hello World!";
    }

    @RequestMapping(value = "index")
    public String index() {
        return "hello world";
    }

    // @RequestParam 简单类型的绑定，可以出来get和post
    @RequestMapping(value = "/get")
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }

    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/get/{id}/{name}")
    public User getUser(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }

}

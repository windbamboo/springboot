
package com.weituitu.demo07.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.weituitu.demo07.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
public class IndexController {

    @Value(value = "${weituitu.secret}")
    private String secret;

    @Value(value = "${weituitu.number}")
    private int number;

    @Value(value = "${weituitu.bignumber}")
    private long bigNumber;

    @Value(value = "${weituitu.number.less.than.ten}")
    private long lessThanTen;


    @Value(value = "${weituitu.number.in.range}")
    private long rangeNumber;


    @Value(value = "${weituitu.desc}")
    private String desc;

    @RequestMapping(value = "home")
    public String home() {
        System.out.println(secret);
        System.out.println(number);
        System.out.println(bigNumber);
        System.out.println(lessThanTen);
        System.out.println(rangeNumber);
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

    private static final long TIMEOUT = 10 * 1000;//30 seconds
    private static final ResponseEntity<String> NOT_MODIFIED_RESPONSE_LIST = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);


    @RequestMapping(value = "/getCurrentLoginUser")
    public DeferredResult<ResponseEntity<String>> getCurrentLoginUser() {
        System.out.println("=====================");
        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>(TIMEOUT, NOT_MODIFIED_RESPONSE_LIST);
        System.out.println("1===" + Thread.currentThread());
        //定时任务获取消息
        // deferredResult.setResult(ResponseEntity.ok("success"));
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                System.out.println("2===" + Thread.currentThread());
                deferredResult.setResult(ResponseEntity.ok("time out"));
                System.out.println("time out");
            }
        });
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                //deferredResult.setResult(ResponseEntity.ok("success!!!"));
                System.out.println("-------------------------");
            }
        });
        System.out.println("3===" + Thread.currentThread());
        return deferredResult;
    }

}

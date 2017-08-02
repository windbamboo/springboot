
package com.weituitu.demo10.web.controller;

import com.weituitu.demo10.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;


@RestController
public class IndexController {

    @RequestMapping(value = "/v1/login")
    public User login() {
        User user = new User();
        user.setId(1);
        user.setName("sundy");
        user.setDate(new Date());
        return user;
    }

    /**
     * 方法配置cors
     *
     * @return
     */
    @RequestMapping(value = "/getUser")
    @CrossOrigin(origins = "http://localhost")
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("sundy");
        user.setDate(new Date());
        return user;
    }

}

package com.weituitu.demo06.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class LoginController extends BaseController {


    @RequestMapping("login")
    public ResponseEntity<String> login(@RequestParam(name = "userName", required = true) String userName,
                                        @RequestParam(name = "passwd") String passwd) {

        if (userName == null || passwd == null||passwd.equals("")) {
            throw new IllegalArgumentException("paramater error");
        }
        if (userName.equals("admin") && passwd.equals("admin")) {
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("failed");

    }

}

package com.weituitu.demo04.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public ResponseEntity<String> login() {
        LOG.info("#########################success");
        return ResponseEntity.ok("success");
    }
}

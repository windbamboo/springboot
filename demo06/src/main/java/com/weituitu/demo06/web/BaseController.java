package com.weituitu.demo06.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * Created by liuguozhu on 2017/7/27.
 */
public class BaseController {

    /**
     * 用于处理通用异常
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> exception(Exception e) throws IOException {
        Integer status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = e.getMessage();
        return ResponseEntity.ok(message);
    }


    /**
     * 用于处理通用异常
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> exception(RuntimeException e) throws IOException {
        Integer status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = e.getMessage();
        return ResponseEntity.ok(message);
    }


}

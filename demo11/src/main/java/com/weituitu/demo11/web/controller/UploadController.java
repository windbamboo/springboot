package com.weituitu.demo11.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by liuguozhu on 2017/8/3.
 */
@Controller
public class UploadController {
    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "upload")
    @ResponseBody
    public ResponseEntity<String> upload(@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) {
        if (null == file) {
            return ResponseEntity.ok("file is null");
        }
        String fileName = file.getOriginalFilename();
        LOG.info("file name is {}", fileName);
        if (fileName.lastIndexOf(".") <= 0) {
            throw new IllegalArgumentException("file format error");
        }
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        LOG.info("suffixName is {}", suffixName);
        String uploadFilePath = request.getServletContext().getRealPath("/");
        LOG.info("uploadFilePath is {}", uploadFilePath);

        File dest = new File(uploadFilePath + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("success");

    }
}

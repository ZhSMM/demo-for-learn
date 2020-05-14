package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/12
 * @description 文件上传
 **/
@RestController
public class FileUploadController {

    @PostMapping("/fileUpload")
    public String fileUpload(@NotNull MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("D:\\"+file.getOriginalFilename()));
        return "文件上传成功！";
    }
}

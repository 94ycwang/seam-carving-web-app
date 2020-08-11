package com.yw.seam.web;

import com.yw.seam.utils.RandomUtil;
import edu.princeton.cs.algs4.Picture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @Value("${user.file.path}")
    private String filePath;

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    @PostMapping("/upload")
    public String fileupload(@RequestParam("pic") MultipartFile multipartFile,
                             Model model) {
        String randomFileName = RandomUtil.getRandomFileName();
        String fileName =  multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String name = fileName.substring(0,fileName.lastIndexOf("."));

        String imgPath = filePath+"user/"+name+randomFileName+suffix;
        try {
            File file = new File(imgPath);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picture picture = new Picture(imgPath);
        model.addAttribute("maxWidth", picture.width());
        model.addAttribute("maxHeight", picture.height());
        model.addAttribute("filePath",filePath+"user/");
        model.addAttribute("fileName",name+randomFileName+suffix);
        return "resize";
    }

}

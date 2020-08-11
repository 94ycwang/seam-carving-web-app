package com.yw.seam.web;

import com.yw.seam.utils.ResizeDemo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class IndexController {

    @Value("${user.file.path}")
    private String filePath;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/resizedemo")
    public String resize(@RequestParam String width, @RequestParam String height,
                         Model model) throws IOException {
        ResizeDemo resizeDemo = new ResizeDemo(width, height, filePath);
        String fileName = resizeDemo.getFileName();
//        model.addAttribute("img","/"+fileName);
        model.addAttribute("img","http://18.223.188.176:8081/"+fileName);
        return "index::imgRefresh";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}

package com.yw.seam.web;

import com.yw.seam.utils.ResizeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResizeController {
    @PostMapping("/resize")
    public String resizeSubmit(@RequestParam("width") Integer width,
                               @RequestParam("height") Integer height,
                               @RequestParam("filePath") String filePath,
                               @RequestParam("fileName") String fileName,
                               @RequestParam("maxWidth") String maxWidth,
                               @RequestParam("maxHeight") String maxHeight, Model model) {

        model.addAttribute("maxWidth", maxWidth);
        model.addAttribute("maxHeight",maxHeight);
        model.addAttribute("filePath",filePath);
        model.addAttribute("fileName",fileName);
        ResizeUtil resizeUtils = new ResizeUtil(width,height,filePath,fileName);
//        model.addAttribute("img","/user/"+ resizeUtils.getNewFilename());
        model.addAttribute("img","http://18.223.188.176:8081/user/"+ resizeUtils.getNewFilename());
        model.addAttribute("name", resizeUtils.getNewFilename());
        return "download";
    }

    @PostMapping("/backresize")
    public String resizeBack(  @RequestParam("maxWidth") String maxWidth,
                               @RequestParam("maxHeight") String maxHeight,
                               @RequestParam("filePath") String filePath,
                               @RequestParam("fileName") String fileName,
                               Model model) {
        model.addAttribute("maxWidth", maxWidth);
        model.addAttribute("maxHeight",maxHeight);
        model.addAttribute("filePath",filePath);
        model.addAttribute("fileName",fileName);
        return "resize";
    }
}

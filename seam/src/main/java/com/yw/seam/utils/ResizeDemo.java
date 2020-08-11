package com.yw.seam.utils;

import edu.princeton.cs.algs4.Picture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;


public class ResizeDemo {
    private final String fileName;

    public ResizeDemo(String width, String height, String path) throws IOException {
//        Resource fileResource = new ClassPathResource("static/images/eximg.jpg");
//        InputStream inputStream = fileResource.getInputStream();
//        byte[] buffer = new byte[inputStream.available()];
//        inputStream.read(buffer);
//        File tmpFile = File.createTempFile("tmpImg", ".jpg");
//        OutputStream outStream = new FileOutputStream(tmpFile);
//        outStream.write(buffer);
//        File file = ResourceUtils.getFile("classpath:static/images/eximg.jpg");
        Picture inputImg = new Picture(path+"static/eximg.jpg");
        int w = inputImg.width();
        int h = inputImg.height();
        Integer removeColumns = w-Math.round(Float.parseFloat(width));
        Integer removeRows = h-Math.round(Float.parseFloat(height));

        SeamCarver sc = new SeamCarver(inputImg);
        for (int i = 0; i < removeRows; i++) {
            sc.removeHorizontalSeam(sc.findHorizontalSeam());
        }
        for (int i = 0; i < removeColumns; i++) {
            sc.removeVerticalSeam(sc.findVerticalSeam());
        }
        Picture outImg = sc.picture();
        fileName = "tmp/eximg"+removeColumns.toString()+removeRows.toString()+".jpg";
        outImg.save(path+fileName);
    }

    public String getFileName(){return fileName;}
}

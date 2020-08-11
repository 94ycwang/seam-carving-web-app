package com.yw.seam.utils;

import edu.princeton.cs.algs4.Picture;

public class ResizeUtil {
    private String newFilename;

    public ResizeUtil(Integer width, Integer height, String filePath, String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String name = fileName.substring(0,fileName.lastIndexOf("."));

        Picture pic = new Picture(filePath+fileName);
        int removeColumns = pic.width()-width;
        int removeRows = pic.height()-height;
        SeamCarver sc = new SeamCarver(pic);
        for (int i = 0; i < removeRows; i++) {
            sc.removeHorizontalSeam(sc.findHorizontalSeam());
        }
        for (int i = 0; i < removeColumns; i++) {
            sc.removeVerticalSeam(sc.findVerticalSeam());
        }

        Picture outImg = sc.picture();
        newFilename = name+"_resize"+suffix;
        outImg.save(filePath+newFilename);
    }
    public String getNewFilename(){
        return newFilename;
    }
}

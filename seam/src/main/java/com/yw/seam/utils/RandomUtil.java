package com.yw.seam.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtil {

        public static String getRandomFileName() {

            SimpleDateFormat simpleDateFormat;

            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

            Date date = new Date();

            String str = simpleDateFormat.format(date);

            Random random = new Random();

            int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;

            return rannum + str;// current time
        }

        public static void main(String[] args) {
            String fileName = RandomUtil.getRandomFileName();
        }
}

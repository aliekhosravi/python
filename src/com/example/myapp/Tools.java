package com.example.myapp;

import android.util.DisplayMetrics;

import java.io.File;

public class Tools {


    public static int getDPI(float size, DisplayMetrics metrics) {
        return (int) (size * metrics.densityDpi) / DisplayMetrics.DENSITY_DEFAULT;
    }


    public static String limitString(String input, int limit) {
        return input.length() > limit ? input.substring(0, limit - 3) + "..." : input;
    }



    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                boolean success = deleteDir(new File(dir, aChildren));
                if (!success) {
                    return false;
                }
            }
        }
        return dir != null && dir.delete();
    }

}

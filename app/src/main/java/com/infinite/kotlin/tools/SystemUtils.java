package com.infinite.kotlin.tools;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/4/13.
 * 系统工具类
 */
public class SystemUtils {

    /**
     * 得到assets文件夹的文件
     * @param mContext
     * @param fileName
     * @return
     */
    public static String getGetAssets(Context mContext,String fileName){
        StringBuilder returnString = new StringBuilder();
        AssetManager assetManager= mContext.getAssets();
        try {
            InputStream inputStream =   assetManager.open(fileName);
            inputStream.read();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                returnString.append(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returnString.toString();
    }


    /**
     * Toast提示
     * @param context
     * @param msg
     */
    public static void show_msg(Context context, String msg) {
        if (context == null) return;
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 转换dp成px
     * @param context
     * @param dp
     * @return
     */
    public static int convertDpToPixel(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static int getScreenWidth(Context context) {
        Display display = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getWidth();
    }

    public static int getScreenHeight(Context context) {
        Display display = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getHeight();
    }
}

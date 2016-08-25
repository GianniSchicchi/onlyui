package com.appmaster;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AMResourceWrapper {
    private static AMResourceWrapper inst = null;

    //bitmap pool
    private Map<String, Bitmap> mapBitmapPool = null;
    private Map<String, String> mapStringPool = null;


    private AMResourceWrapper() {
        //private constructor

        if (mapBitmapPool == null) {
            mapBitmapPool = Collections.synchronizedMap(new HashMap<String, Bitmap>());
        }

        if (mapStringPool == null) {
            //read / parse file
            //...


        }
    }

    //-------------------------------------
    //
    //
    public static synchronized AMResourceWrapper getInstance() {
        if (inst == null)
            inst = new AMResourceWrapper();
        return inst;
    }

    //-------------------------------------
    //
    //
    public Bitmap getBitmap(Activity act, String imageName) {
        Bitmap tmp_bmp = null;

        //FIND IMAGE FROM BITMAP POOL
        if (mapBitmapPool.containsKey(imageName) == true) {
            tmp_bmp = mapBitmapPool.get(imageName);
        }

        if (tmp_bmp == null) {
            File bmpFile = new File(act.getFilesDir() + "/" + imageName + ".png");
            if (bmpFile.exists() == false) {
                Log.d("Unity - setImageResource", imageName + " FILE NOT EXIST !!! -71");
                return null;
            }

            tmp_bmp = BitmapFactory.decodeFile(bmpFile.getAbsolutePath());

            //ADD INTO BITMAP POOL
            mapBitmapPool.put(imageName, tmp_bmp);

        }

        return tmp_bmp;
    }

    public void setImageResource(Activity act, ImageView iv, String imageName) {
        Bitmap tmp_bmp = null;
        tmp_bmp = getBitmap(act, imageName);

        iv.setImageBitmap(tmp_bmp);

    }

    public void setImageResource(Activity act, ImageButton iv, String imageName) {
        Bitmap tmp_bmp = null;
        tmp_bmp = getBitmap(act, imageName);

        iv.setImageBitmap(tmp_bmp);
    }

    public Drawable getDrawable(Activity act, String imageName) {
        Bitmap tmp_bmp = null;
        tmp_bmp = getBitmap(act, imageName);

        return new BitmapDrawable(tmp_bmp);
    }

    public String getString(Activity act, String identifier) {
        if (mapStringPool == null) {

            //create mapstring pool
            mapStringPool = Collections.synchronizedMap(new HashMap<String, String>());

            //read from file
            StringBuilder sb = null;
            try {

                Log.d("Unity - AMResourceWrapper", "mapStringPool is null, trying to initialize it...");
                FileInputStream fis = act.openFileInput("string.json");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(isr);
                sb = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }

                //parse data
                JSONObject jo = new JSONObject(sb.toString());

                Iterator<String> nameItr = jo.keys();
                while (nameItr.hasNext()) {
                    String key = nameItr.next();
                    mapStringPool.put(key, jo.getString(key));
                }


            } catch (Exception e) {
                //delete current file
                Log.d("Unity - AMResourceWrapper", "parse data error(137), data=" + sb.toString() + ", error =" + e.toString());
            }
        }

        String retdata = "";
        if (mapStringPool.containsKey(identifier) == true) {
            retdata = mapStringPool.get(identifier);
        }
        return retdata;
    }


}
package com.arcode.androidutilities.Network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class NetworkUtils {

    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";

    public static String readStream(InputStream in) throws IOException {
        BufferedReader reader;
        StringBuilder response = new StringBuilder();
        reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    public static Bitmap getBitmapFromURL(String src) throws IOException {
        java.net.URL url = new java.net.URL(src);
        HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream input = connection.getInputStream();
        return BitmapFactory.decodeStream(input);
    }
}

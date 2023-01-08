package com.example.restapi.services;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;

import com.example.restapi.models.State;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DataServices {
    private ArrayList<State> arrState = new ArrayList<State>();


    public ArrayList<State> getArrState() {
        String sURL = "https://restcountries.com/v2/all?fields=name,nativeName,borders,flags";

        URL url = null;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            url = new URL(sURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection request = null;

        try {
            request = (HttpURLConnection) url.openConnection();
            request.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser jp = new JsonParser();
        try {
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonArray rootObj = root.getAsJsonArray();
            for (JsonElement je : rootObj) {
                JsonObject obj = je.getAsJsonObject();
                JsonElement entrieName = obj.get("name");
                JsonElement entrieNativeName = obj.get("nativeName");
                JsonElement entrieFlag = obj.get("flags").getAsJsonObject().get("png");

                String name = entrieName.toString().replace("\"", "").trim();
                String nativeName = entrieNativeName.toString().replace("\"", "").trim();
                String flagUrl = entrieFlag.toString().replace("\"", "").trim();
                Bitmap flag = flagBitmap(flagUrl);

                ArrayList<String> arrayBorders = new ArrayList<String>();

                JsonElement entrieBorders = obj.get("borders");
                if (entrieBorders != null) {
                    JsonArray entrieBordersArr = entrieBorders.getAsJsonArray();

                    for (JsonElement j : entrieBordersArr) {
                        String s = j.toString().replace("\"", "").trim();
                        arrayBorders.add(s);
                    }
                }
                arrState.add(new State(name, arrayBorders, nativeName, flag));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrState;
    }

    private Bitmap flagBitmap(String flagUrl) {
        try {
            URL newurl = new URL(flagUrl);
            Bitmap mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
            return mIcon_val;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

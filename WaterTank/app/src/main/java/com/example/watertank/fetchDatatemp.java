package com.example.watertank;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchDatatemp extends AsyncTask<Void,Void,Void> {
    String data="";
    String dataParsed="";
    String singleParsed="";
    @Override
    protected Void doInBackground(Void... voids) {
       try{
           URL url=new URL("http://192.168.1.104/mydb/temp.php");
           HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
           InputStream inputStream=httpURLConnection.getInputStream();
           BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
           String line="";
           while(line != null){
               line = bufferedReader.readLine();
               data=data + line;
           }
           JSONArray ja=new JSONArray(data);
           for (int i = 0; i <ja.length() ; i++) {
               JSONObject jo=(JSONObject) ja.get(i);
               singleParsed=jo.get("datatime")+"     "+
                            jo.get("rec_temp")+"     "+
                            jo.get("rec_hum")+"      "+"\n";
               dataParsed = dataParsed+singleParsed;

           }
       }catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (JSONException e) {
           e.printStackTrace();
       }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Main3Activity.data.setText(this.dataParsed);
    }

}

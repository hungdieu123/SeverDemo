package com.HungViet.severdemo;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ClassCucManh extends AsyncTask<Void,Void,Void> {
    String duongdan = MainActivity.link18;
    TextView textView;
    Context context;
    ProgressDialog progressDialog;
    String dulieutuyetmat;
    int soa;

    public ClassCucManh(TextView textView, Context context,int soa) {

        this.textView = textView;
        this.context = context;
        this.soa=soa;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("oke Men");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... pram) {

        try {
            String a=String.valueOf(MainActivity.x);


            duongdan+="?tenbiensever="+ this.soa;

            URL url = new URL(duongdan);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String dulieu="";
            StringBuilder stringBuilder=new StringBuilder();

            while ((dulieu=bufferedReader.readLine())!= null){
                stringBuilder.append(dulieu);
            }
            dulieutuyetmat=stringBuilder.toString();
            urlConnection.disconnect();


        }catch (Exception e){
            e.printStackTrace();
        }



        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();

        }
        textView.setText(dulieutuyetmat);
    }

}

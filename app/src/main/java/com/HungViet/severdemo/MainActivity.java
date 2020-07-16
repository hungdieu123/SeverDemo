package com.HungViet.severdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    public static int x=1;
    public static final String link18 = "http://172.16.6.255:8080/anh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassCucManh classCucManh= new ClassCucManh(tv1,MainActivity.this,x);
                classCucManh.execute();
            }
        });


    }
}
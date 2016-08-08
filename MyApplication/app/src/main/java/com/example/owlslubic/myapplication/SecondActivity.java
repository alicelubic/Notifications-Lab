package com.example.owlslubic.myapplication;

import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = (ImageView) findViewById(R.id.imageview);
        textView = (TextView) findViewById(R.id.second_text);


        Intent intent = getIntent();

        if(intent.getBooleanExtra("status", false)){
            imageView.setImageResource(R.drawable.ic_yes_wifi);
            textView.setText("Connection Established");

            NotificationManagerCompat.from(SecondActivity.this).cancel(1138);

        }else{
            imageView.setImageResource(R.drawable.ic_no_wifi);
            textView.setText("No Connection Found...");
        }


    }

}

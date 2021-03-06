package com.example.owlslubic.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.first_text);

        ConnectivityManager conMng = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conMng.getActiveNetworkInfo();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1138, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_lil_dude)
                .setContentTitle("Network Status")
                .setContentText("Checking for service...");
//                .setContentIntent(pendingIntent);
//
        if (networkInfo != null && networkInfo.isConnected()) {
            NotificationCompat.BigPictureStyle pictureStyle = new NotificationCompat.BigPictureStyle();
            pictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_input_add));
            builder.setStyle(pictureStyle);
           // builder.setAutoCancel(true);//so that it goes away if it's true
            intent.putExtra("status", Boolean.TRUE);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 1138, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);



        } else {
            NotificationCompat.BigPictureStyle pictureStyle = new NotificationCompat.BigPictureStyle();
            pictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_delete));
            builder.setStyle(pictureStyle);
            intent.putExtra("status", Boolean.FALSE);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 1139, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);

        }

        NotificationManagerCompat.from(MainActivity.this).notify(1138, builder.build());

    }
}

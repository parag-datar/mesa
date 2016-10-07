package com.mesa.notificationmanager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder mNotificationBuilder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeNotificationManager();
        setListeners();

    }

    private void initializeNotificationManager(){
        mNotificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mNotificationBuilder.setContentIntent(resultPendingIntent);

    }

    private void showNotification(){
        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mNotificationBuilder.build());

        Toast.makeText(getApplicationContext(), "Sending a notification", Toast.LENGTH_SHORT).show();

    }

    private void setListeners(){
        final Button button = (Button) findViewById(R.id.notify);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showNotification();
            }
        });
    }
}

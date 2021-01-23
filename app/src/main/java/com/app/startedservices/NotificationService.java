package com.app.startedservices;

import android.app.IntentService;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class NotificationService extends IntentService {

    public NotificationService() {
        super("NotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my_channel_id_01")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText(content)
                .setContentTitle(title)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{0, 1000})
                .setAutoCancel(true);
        builder.build();

    }
}
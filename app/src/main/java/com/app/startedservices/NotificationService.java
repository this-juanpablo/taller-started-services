package com.app.startedservices;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class NotificationService extends IntentService {

    public NotificationService() {
        super("NotificationService");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            try {
                wait(5000);
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                String CHANNEL_ID = "CHANNEL";
                NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_LOW);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent2, 0);
                Notification notification = new Notification.Builder(getApplicationContext(), CHANNEL_ID)
                        .setContentText(content)
                        .setContentTitle(title)
                        .setContentIntent(pendingIntent)
                        .addAction(android.R.drawable.sym_action_chat, "Notificación StartedServices", pendingIntent)
                        .setChannelId(CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.sym_action_chat)
                        .build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.notify(1, notification);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
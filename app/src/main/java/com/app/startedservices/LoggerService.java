package com.app.startedservices;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class LoggerService extends IntentService {

    public LoggerService() {
        super("LoggerService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            try {
                wait(5000);
                showLogger(intent.getStringExtra("type"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showLogger(String type) {
        switch (type) {
            case "Logger verbose":
                Log.v("LoggerService", type);
                break;
            case "Logger debug":
                Log.d("LoggerService", type);
                break;
            case "Logger information":
                Log.i("LoggerService", type);
                break;
            case "Logger warning":
                Log.w("LoggerService", type);
                break;
            case "Logger error":
                Log.e("LoggerService", type);
                break;
        }
    }
}
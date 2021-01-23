package com.app.startedservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogger, btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnLogger.setOnClickListener(click -> {
            Intent logger = new Intent(this, LoggerActivity.class);
            startActivity(logger);
        });

        btnNotification.setOnClickListener(click -> {
            Intent notification = new Intent(this, NotificationActivity.class);
            startActivity(notification);
        });
    }

    private void init() {
        btnLogger = findViewById(R.id.btnLogger);
        btnNotification = findViewById(R.id.btnNotification);
    }
}
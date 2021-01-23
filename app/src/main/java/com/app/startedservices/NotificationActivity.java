package com.app.startedservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity {

    private Button btnSend;
    private EditText eTxtTitle, eTxtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        init();

        btnSend.setOnClickListener(click -> {
            String title = eTxtTitle.getText().toString();
            String content = eTxtContent.getText().toString();

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Los campos deben ser rellenos.", Toast.LENGTH_SHORT).show();
            } else {
                Intent notification = new Intent(this, NotificationService.class);
                notification.putExtra("title", title);
                notification.putExtra("content", content);
                startService(notification);
            }
        });
    }

    private void init() {
        btnSend = findViewById(R.id.btnServiceNotification);
        eTxtTitle = findViewById(R.id.title);
        eTxtContent = findViewById(R.id.content);
    }
}
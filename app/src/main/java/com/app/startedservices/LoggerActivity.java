package com.app.startedservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class LoggerActivity extends AppCompatActivity {

    private Button btnService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        init();

        btnService.setOnClickListener(click -> {
            Intent service = new Intent(this, LoggerService.class);
            RadioButton checked = findViewById(((RadioGroup) findViewById(R.id.rGroup)).getCheckedRadioButtonId());
            service.putExtra("type", checked.getText().toString());
            startService(service);
        });
    }

    private void init() {
        btnService = findViewById(R.id.btnServiceLogger);
    }
}
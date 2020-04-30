package com.jjh.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView message;
    private Intent startServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);
    }

    public void onStartButtonClick(View v) {
        try {
            Log.d(TAG, "Starting service!");
            Intent startServiceIntent = new Intent(this, SampleService.class);
            startService(startServiceIntent);
            message.setText("Started Service");
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void onStopButtonClick(View v) {
        try {
            Log.d(TAG, "Stopping service!");
            stopService(startServiceIntent);
            message.setText("Stopped Service");
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}

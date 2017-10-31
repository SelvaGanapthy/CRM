package com.example.admin.crm.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.admin.crm.activities.LoginCRM;
import com.example.admin.crm.R;


public class SplashScreen extends AppCompatActivity {
    public static final int requestcode_permisson = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        if (checkPermisson())
            splash();
        else
        requestPermission();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public boolean checkPermisson() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        int result2 = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_PHONE_STATE);
        int result3 = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.PROCESS_OUTGOING_CALLS);
        return (result == PackageManager.PERMISSION_GRANTED) && (result1 == PackageManager.PERMISSION_GRANTED) && (result2 == PackageManager.PERMISSION_GRANTED) && (result3 == PackageManager.PERMISSION_GRANTED);

    }

    public void requestPermission() {
        ActivityCompat.requestPermissions(SplashScreen.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE, Manifest.permission.PROCESS_OUTGOING_CALLS}, requestcode_permisson);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case requestcode_permisson:
                if (grantResults.length > 0) {
                    boolean StoragePermisson = grantResults[0] == PackageManager.PERMISSION_DENIED;
                    boolean RecordPermisson = grantResults[1] == PackageManager.PERMISSION_DENIED;
                    boolean outgoingcallPermisson = grantResults[0] == PackageManager.PERMISSION_DENIED;
                    boolean readphonestatePermisson = grantResults[0] == PackageManager.PERMISSION_DENIED;
                    if (StoragePermisson && RecordPermisson && outgoingcallPermisson && readphonestatePermisson) {
                        Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                        requestPermission();
                    } else
                        splash();
                }
                break;
        }
    }

    public void splash() {
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, LoginCRM.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}

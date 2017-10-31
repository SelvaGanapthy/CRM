package com.example.admin.crm.activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.admin.crm.R;
import com.example.admin.crm.navigation.MainActivityNavigation;

public class LoginCRM extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout getclient_layout, verifypening_layout;
    ScrollView login_layout;
    EditText id_Username, id_Userpass;
    Button bt_Login, getclient_verify_bt, verifypend_close_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlead_login);
        initialize();
    }

    public void initialize() {
        getclient_layout = (RelativeLayout) findViewById(R.id.getclient_layout);
        verifypening_layout = (RelativeLayout) findViewById(R.id.verifypening_layout);
        id_Username = (EditText) findViewById(R.id.id_username);
        id_Userpass = (EditText) findViewById(R.id.id_userpass);
        login_layout = (ScrollView) findViewById(R.id.login_layout);
        bt_Login = (Button) findViewById(R.id.bt_login);
        getclient_verify_bt = (Button) findViewById(R.id.getclient_verify_bt);
        verifypend_close_bt = (Button) findViewById(R.id.verifypend_close_bt);
        verifypend_close_bt.setOnClickListener(this);
        getclient_verify_bt.setOnClickListener(this);
    }

    public void validate(View view) {
        boolean f1, f2;
        f1 = f2 = true;
        if (id_Username.length() == 0 || id_Username.length() >= 15) {
            id_Username.setError("Enter the username & which is less than 15 char");
            f1 = false;
        }
        if (id_Userpass.length() == 0 || id_Userpass.length() >= 15) {
            id_Userpass.setError("Enter the password ");
            f2 = false;
        }
        if (f1 && f2) {
            if (id_Username.getText().toString().equals("admin") && id_Userpass.getText().toString().equals("admin"))
                startActivity(new Intent(LoginCRM.this, MainActivityNavigation.class));
            else
                Snackbar.make(view, "\t\t username & password was wrong", Snackbar.LENGTH_LONG).show();

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getclient_verify_bt:
                getclient_layout.setVisibility(View.GONE);
                verifypening_layout.setVisibility(View.VISIBLE);
                login_layout.setVisibility(View.GONE);
                break;
            case R.id.verifypend_close_bt:
                getclient_layout.setVisibility(View.GONE);
                verifypening_layout.setVisibility(View.GONE);
                login_layout.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void onBackPressed() {
        if (login_layout.getVisibility() == View.VISIBLE) {
            login_layout.setVisibility(View.GONE);
            getclient_layout.setVisibility(View.GONE);
            verifypening_layout.setVisibility(View.VISIBLE);

        } else if (verifypening_layout.getVisibility() == View.VISIBLE) {
            login_layout.setVisibility(View.GONE);
            getclient_layout.setVisibility(View.VISIBLE);
            verifypening_layout.setVisibility(View.GONE);
        }
        else if(  getclient_layout.getVisibility()==View.VISIBLE)
        {
            Toast.makeText(getApplicationContext(), "getClosed", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }
}

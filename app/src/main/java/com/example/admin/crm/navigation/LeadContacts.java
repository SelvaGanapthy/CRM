package com.example.admin.crm.navigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.crm.R;

public class LeadContacts extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_contacts);
        rv = (RecyclerView) findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setAdapter(new ContactAdapter(this, new String[]{"LEAD 1", "LEAD 2", "LEAD 3", "LEAD 4", "LEAD 5", "LEAD 6", "LEAD 7", "LEAD 8", "LEAD 9", "LEAD 10"}));
    }
}

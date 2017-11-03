package com.example.admin.crm.navigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.example.admin.crm.R;

public class LeadContacts extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_contacts);
        recyclerView = (RecyclerView) findViewById(R.id.rv_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ContactAdapter(this, new String[]{"LEAD 1", "LEAD 2", "LEAD 3", "LEAD 4", "LEAD 5", "LEAD 6", "LEAD 7", "LEAD 8", "LEAD 9", "LEAD 10"}));
    }
}

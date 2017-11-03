package com.example.admin.crm.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.crm.R;

/**
 * Created by Admin on 10/30/2017.
 */

public class Tab1_Data_Adapter extends RecyclerView.Adapter<Tab1_Data_Adapter.ViewHolder> {
    View row;
    String[] data;
    Navi_Tab1 context;

    public Tab1_Data_Adapter(Navi_Tab1 ctx, String[] data) {
        this.context = ctx;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_adapterdata, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(Tab1_Data_Adapter.ViewHolder holder, final int position) {
        holder.tab1_titletv.setText(data[position]);
        holder.tab1_msg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, " " + data[position] + "PASS to the SMS", Snackbar.LENGTH_SHORT).show();
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+919884004900", null, "Hi This is would be test", null, null);
            }
        });
        holder.tab1_call_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, " " + data[position] + "Connect to CALL", Snackbar.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+919884004900"));
                context.startActivity(callIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tab1_titletv;
        ImageView tab1_msg_iv, tab1_call_iv;

        public ViewHolder(View itemView) {
            super(itemView);
            tab1_titletv = (TextView) itemView.findViewById(R.id.tab1_titletv);
            tab1_msg_iv = (ImageView) itemView.findViewById(R.id.tab1_mgs_iv);
            tab1_call_iv = (ImageView) itemView.findViewById(R.id.tab1_call_iv);
        }
    }
}

package com.example.admin.crm.navigation;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.admin.crm.R;
/**
 * Created by Admin on 10/30/2017.
 */

public class Tab1_Data_Adapter  extends RecyclerView.Adapter<Tab1_Data_Adapter.ViewHolder> {
    View row;
    String[] data;

    public Tab1_Data_Adapter(String[] data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_adapterdata, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(Tab1_Data_Adapter.ViewHolder holder,final int position) {
        holder.tab1_titletv.setText(data[position]);
        holder.tab1_msgiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, " " + data[position], Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tab1_titletv;
        ImageView tab1_msgiv;

        public ViewHolder(View itemView) {
            super(itemView);
            tab1_titletv = (TextView) itemView.findViewById(R.id.tab1_titletv);
            tab1_msgiv = (ImageView) itemView.findViewById(R.id.tab1_mgs_iv);
        }
    }
}

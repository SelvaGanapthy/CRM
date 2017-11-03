package com.example.admin.crm.navigation;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.admin.crm.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Admin on 11/3/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    View row;
    String[] data;
    Context context;

    public ContactAdapter(Context ctx, String[] data) {
        this.context = ctx;
        this.data = data;
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_adpterdata, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {
        holder.contacts_leadorder_notv.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView contacts_lead_proimg;
        TextView contacts_leadorder_notv, contacts_leadphno_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            contacts_lead_proimg = (CircleImageView) itemView.findViewById(R.id.contacts_profile_Image);
            contacts_leadorder_notv = (TextView) itemView.findViewById(R.id.contacts_leadorder_tv);
            contacts_leadphno_tv = (TextView) itemView.findViewById(R.id.contacts_leadphno_tv);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Snackbar.make(v, "Lead" + (position + 1), Snackbar.LENGTH_SHORT).show();
        }
    }
}

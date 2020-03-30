package org.caresptogo.covid_19tg.model;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.caresptogo.covid_19tg.R;


public class HolderCharge extends RecyclerView.ViewHolder{

    private TextView title;
    private TextView content;
    public Context context;

    public HolderCharge(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.date);
        content = (TextView) itemView.findViewById(R.id.title);
    }

    public void bind(Charge charge){
        title.setText(charge.getDate());
        content.setText(charge.getTitle());

    }

}

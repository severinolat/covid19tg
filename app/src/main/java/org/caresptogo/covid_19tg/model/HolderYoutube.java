package org.caresptogo.covid_19tg.model;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.caresptogo.covid_19tg.R;

public class HolderYoutube extends RecyclerView.ViewHolder{

    private TextView title;
    public Context context;

    public HolderYoutube(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.vTitle);
    }

    public void bind(Youtube youtube){
        title.setText(youtube.title);

    }
}

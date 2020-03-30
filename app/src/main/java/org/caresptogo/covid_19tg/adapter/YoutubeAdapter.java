package org.caresptogo.covid_19tg.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.caresptogo.covid_19tg.DetailsInfoActivity;
import org.caresptogo.covid_19tg.R;
import org.caresptogo.covid_19tg.model.HolderYoutube;
import org.caresptogo.covid_19tg.model.OnItemClick;
import org.caresptogo.covid_19tg.model.Youtube;

import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<HolderYoutube> {


    List<Youtube> list;
    private OnItemClick callback;

    public YoutubeAdapter(List<Youtube> charges, Context context) {
        this.list = charges;
    }

    @Override
    public HolderYoutube onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_project1,viewGroup,false);
        return new HolderYoutube(view);
    }

    @Override
    public void onBindViewHolder(HolderYoutube myViewHolder, final int position) {
        final Youtube charge = list.get(position);
        myViewHolder.bind(charge);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callback.onClick(position);
                Youtube selectedCharge = list.get(position);
                v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(selectedCharge.getLink())));

            }
        });
        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

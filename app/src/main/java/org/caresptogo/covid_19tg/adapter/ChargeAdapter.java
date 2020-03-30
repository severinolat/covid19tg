package org.caresptogo.covid_19tg.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import org.caresptogo.covid_19tg.DetailsInfoActivity;
import org.caresptogo.covid_19tg.R;
import org.caresptogo.covid_19tg.model.Charge;
import org.caresptogo.covid_19tg.model.HolderCharge;
import org.caresptogo.covid_19tg.model.OnItemClick;

import java.util.List;

public class ChargeAdapter extends RecyclerView.Adapter<HolderCharge> {


    List<Charge> list;
    private OnItemClick callback;

    public ChargeAdapter(List<Charge> charges, Context context) {
        this.list = charges;
    }

    @Override
    public HolderCharge onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_justificatif,viewGroup,false);
        return new HolderCharge(view);
    }

    @Override
    public void onBindViewHolder(HolderCharge myViewHolder, final int position) {
        final Charge charge = list.get(position);
        myViewHolder.bind(charge);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callback.onClick(position);
                Intent i = new Intent(v.getContext(), DetailsInfoActivity.class);
                Charge selectedCharge = list.get(position);
                i.putExtra("info", selectedCharge);
                v.getContext().startActivity(i);

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

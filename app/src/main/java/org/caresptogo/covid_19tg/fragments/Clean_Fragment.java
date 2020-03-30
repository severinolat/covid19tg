package org.caresptogo.covid_19tg.fragments;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.caresptogo.covid_19tg.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

import static org.caresptogo.covid_19tg.config.AppMain.mFirebaseDatabaseReference;


public class Clean_Fragment extends Fragment {


    private View view;
    private TextView txtUpdate, txtCas, txtDeces, txtGueri;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.clean_fragment, container, false);
        txtCas = view.findViewById(R.id.txtCas);
        txtUpdate = view.findViewById(R.id.txtUpdate);
        txtDeces = view.findViewById(R.id.txtDeces);
        txtGueri = view.findViewById(R.id.txtGueri);

        Long tsLong = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(tsLong);
        String date = DateFormat.format("dd MMMM yyyy", calendar).toString();


        mFirebaseDatabaseReference.child("statistiques").child("togo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("zzzzzz",dataSnapshot.getKey());
                Long cas = dataSnapshot.child("confirme").getValue(Long.class);
                Long gueri = dataSnapshot.child("gueri").getValue(Long.class);
                Long deces = dataSnapshot.child("deces").getValue(Long.class);
                Long malade = dataSnapshot.child("malade").getValue(Long.class);
                String update = dataSnapshot.child("date").getValue(String.class);
                txtCas.setText(" "+separateMille(cas)+" " );
                txtDeces.setText(" "+separateMille(deces)+" ");
                txtGueri.setText(" "+separateMille(gueri)+" ");
                txtUpdate.setText(update);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;



    }


    public static String separateMille(Long sp){
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return String.valueOf(formatter.format(sp));
    }
}

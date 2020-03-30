package org.caresptogo.covid_19tg;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import static org.caresptogo.covid_19tg.config.AppMain.mFirebaseDatabaseReference;

public class StatistiquesActivity extends AppCompatActivity {
    private TextView txtDate, txtCas, txtDeces, txtGueri, txtMalade;
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);


        back = findViewById(R.id.back);
        txtCas = findViewById(R.id.txtCas);
        txtDeces = findViewById(R.id.txtDeces);
        txtGueri = findViewById(R.id.txtGueri);
        txtMalade = findViewById(R.id.txtMalade);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mFirebaseDatabaseReference.child("statistiques").child("monde").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("zzzzzz",dataSnapshot.getKey());
                Long cas = dataSnapshot.child("confirme").getValue(Long.class);
                Long gueri = dataSnapshot.child("gueri").getValue(Long.class);
                Long deces = dataSnapshot.child("deces").getValue(Long.class);
                Long malade = dataSnapshot.child("malade").getValue(Long.class);
                txtCas.setText(separateMille(cas));
                txtDeces.setText(separateMille(deces) );
                txtGueri.setText(separateMille(gueri) );
                txtMalade.setText(separateMille(malade));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static String separateMille(Long sp){
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return String.valueOf(formatter.format(sp));
    }
}

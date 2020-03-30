package org.caresptogo.covid_19tg;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.caresptogo.covid_19tg.adapter.ChargeAdapter;
import org.caresptogo.covid_19tg.model.Charge;

import java.util.ArrayList;

import static org.caresptogo.covid_19tg.config.AppMain.mFirebaseDatabaseReference;

public class AutresActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ChargeAdapter myAdapter;
    private ArrayList<Charge> mList;
    ProgressBar pbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autres);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Autres infos");

        pbar=(ProgressBar)findViewById(R.id.pbar);
        recyclerView = findViewById(R.id.recyclerView);
        mList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        myAdapter = new ChargeAdapter(mList,getApplicationContext());


        recyclerView.setAdapter(myAdapter);




        mFirebaseDatabaseReference.child("autres").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Charge centre = dataSnapshot1.getValue(Charge.class);
                    mList.add(centre);
                    pbar.setVisibility(View.INVISIBLE);
                }
                myAdapter.notifyDataSetChanged();

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
}

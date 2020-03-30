package org.caresptogo.covid_19tg;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.caresptogo.covid_19tg.adapter.YoutubeAdapter;
import org.caresptogo.covid_19tg.model.Youtube;

import java.util.ArrayList;

import static org.caresptogo.covid_19tg.config.AppMain.mFirebaseDatabaseReference;

public class VideosActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    YoutubeAdapter myAdapter;
    private ArrayList<Youtube> mList;
    ProgressBar pbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);


        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Vidéos");

        pbar=(ProgressBar)findViewById(R.id.pbar);
        recyclerView = findViewById(R.id.recyclerView);
        mList = new ArrayList<>();
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        myAdapter = new YoutubeAdapter(mList,getApplicationContext());


        recyclerView.setAdapter(myAdapter);




        mFirebaseDatabaseReference.child("videos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Youtube centre = dataSnapshot1.getValue(Youtube.class);
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

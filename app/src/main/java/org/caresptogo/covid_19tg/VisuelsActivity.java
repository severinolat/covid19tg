package org.caresptogo.covid_19tg;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;

import com.mindorks.placeholderview.PlaceHolderView;

import org.caresptogo.covid_19tg.config.GalleryItem;

public class VisuelsActivity extends AppCompatActivity {

    private PlaceHolderView mGalleryView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visuels);


        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Visuels");

        mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);
        mGalleryView.getBuilder().setLayoutManager(new GridLayoutManager(this.getApplicationContext(), 2));

        mGalleryView
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.vs1)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.vs2)))

                ;

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

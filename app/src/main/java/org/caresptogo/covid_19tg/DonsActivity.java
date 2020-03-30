package org.caresptogo.covid_19tg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DonsActivity extends AppCompatActivity {
    private ImageView imgSoli;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dons);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Faire un don");

        imgSoli = findViewById(R.id.imgSoli);
        Glide.with(getApplicationContext())
                .load(R.drawable.solid)
                .apply(RequestOptions.circleCropTransform())
                .into(imgSoli);
    }

    public void openLink(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cotizup.com/togo-covid19")));
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

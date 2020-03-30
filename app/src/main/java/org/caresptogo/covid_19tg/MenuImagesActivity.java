package org.caresptogo.covid_19tg;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_images);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Visuels");
    }

    public void openMenu(View v){
        int dash = Integer.valueOf(v.getTag().toString());
        switch (dash){
            case 0:

                startActivity(new Intent(MenuImagesActivity.this, ImgDistanciationActivity.class));
                break;
            case 1:
                startActivity(new Intent(MenuImagesActivity.this, ImgLaveMainActivity.class));
                break;

            case 2:

                startActivity(new Intent(MenuImagesActivity.this, ImgIsolationActivity.class));
                break;

            case 3:

                startActivity(new Intent(MenuImagesActivity.this, ImgDesinformationActivity.class));
                break;

            case 4:

                startActivity(new Intent(MenuImagesActivity.this, VideosActivity.class));
                break;





        }
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

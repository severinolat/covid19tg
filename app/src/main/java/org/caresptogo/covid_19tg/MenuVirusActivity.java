package org.caresptogo.covid_19tg;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuVirusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_virus);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.le_virus));
    }

    public void openMenu(View v){
        int dash = Integer.valueOf(v.getTag().toString());
        switch (dash){
            case 0:

                startActivity(new Intent(MenuVirusActivity.this, DefinitionActivity.class));
                break;
            case 1:
                startActivity(new Intent(MenuVirusActivity.this, SignesActivity.class));
                break;

            case 2:

                startActivity(new Intent(MenuVirusActivity.this, ModeTransActivity.class));
                break;
            case 3:
                startActivity(new Intent(MenuVirusActivity.this, PersonnesRisqueActivity.class));
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

package org.caresptogo.covid_19tg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AboutActivity extends AppCompatActivity {
    private ImageView exit;
    private TextView appVersion;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        appVersion = findViewById(R.id.app_version);

        appVersion.setText(appVersion.getText()+" "+ BuildConfig.VERSION_NAME);

        exit=(ImageView)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
    }

    public void openWeb(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.caresp-togo.org/")));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

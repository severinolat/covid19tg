package org.caresptogo.covid_19tg;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import org.caresptogo.covid_19tg.fragments.Clean_Fragment;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++) {
            bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL);
        }



        /*roughike bottombar library code is here*/

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment = null;
                switch (tabId) {
                    case R.id.home:
                        replace_fragment(new Clean_Fragment());
                        break;
                    case R.id.more:
                        Intent intent = new Intent(MainActivity.this, AutresActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.dons:
                        Intent inten = new Intent(MainActivity.this, DonsActivity.class);
                        startActivity(inten);
                        break;
                    case R.id.about:
                        Intent i = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(i);
                        break;


                }


            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                Fragment fragment = null;
                switch (tabId) {
                    case R.id.home:
                        replace_fragment(new Clean_Fragment());
                        break;
                    case R.id.more:
                        Intent intent = new Intent(MainActivity.this, AutresActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.dons:
                        Intent inten = new Intent(MainActivity.this, DonsActivity.class);
                        startActivity(inten);
                        break;
                    case R.id.about:
                        Intent i = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(i);
                        break;


                }
            }
        });
    }

    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }

    public void openMenu(View v){
        int dash = Integer.valueOf(v.getTag().toString());
        switch (dash){
            case 0:

                startActivity(new Intent(MainActivity.this, MenuVirusActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, TraitementGuerirActivity.class));
                break;

            case 2:

                startActivity(new Intent(MainActivity.this, StatistiquesActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, MenuImagesActivity.class));
                break;




        }
    }


}

package org.caresptogo.covid_19tg.config;

import android.app.Application;


import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppMain extends Application {
    public static DatabaseReference mFirebaseDatabaseReference;
    public static DatabaseReference mDatabase;
    public static FirebaseDatabase mFirebaseInstance;
    public static Firebase ref;
    public static FirebaseAuth mAuth;
    public static FirebaseUser currentUser;

    @Override
    public void onCreate() {
        super.onCreate();
        //Previous versions of Firebase
        Firebase.setAndroidContext(this);
        if(!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        ref = new Firebase("https://covidtg-cc741.firebaseio.com/");
        mAuth = FirebaseAuth.getInstance();


    }

}

package info.codingalecr.ecofuel;

import android.app.Application;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;

import info.codingalecr.ecofuel.views.activities.FuelListActivity;

/**
 * Created by aulate on 12/12/17.
 */

public class EcoFuelApplication extends Application implements FirebaseAuth.AuthStateListener{

    private FirebaseAuth mFirebaseAuth;

    @Override
    public void onCreate() {
        super.onCreate();
        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseAuth.addAuthStateListener(this);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if (firebaseAuth.getCurrentUser() == null) {
            Intent i = new Intent(this, FuelListActivity.class);
            startActivity(i);
        }
    }


}

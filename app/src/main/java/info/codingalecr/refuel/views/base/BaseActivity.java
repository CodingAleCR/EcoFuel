package info.codingalecr.refuel.views.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

import info.codingalecr.refuel.R;

/**
 * Created by aulate on 12/12/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener {

    private FirebaseAuth mFirebaseAuth;
    private ViewDataBinding mBinding;
    // Choose an arbitrary request code value
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayout());
        if (withToolbar()) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
        init();
    }

    public void init() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseAuth.addAuthStateListener(this);
        initObj();
        initUI();
    }

    public ViewDataBinding getBaseBinding() {
        return mBinding;
    }

    public abstract boolean withToolbar();

    public abstract int getLayout();

    public abstract ViewDataBinding getBinding();

    public abstract void initObj();

    public abstract void initUI();

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if (firebaseAuth.getCurrentUser() == null) {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(
                                    Arrays.asList(
                                            new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build())
                            )
                            .build(),
                    RC_SIGN_IN);
        }
    }
}

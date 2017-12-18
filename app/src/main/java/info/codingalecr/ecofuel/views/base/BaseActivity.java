package info.codingalecr.ecofuel.views.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import info.codingalecr.ecofuel.R;

/**
 * Created by aulate on 12/12/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ViewDataBinding mBinding;

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
}

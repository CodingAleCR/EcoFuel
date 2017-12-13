package info.codingalecr.ecofuel.views.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityMenuBinding;
import info.codingalecr.ecofuel.helpers.MenuClickHelper;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBinding.btnFuelList.setOnClickListener(MenuClickHelper.getRefuelListClickListener(this));
        mBinding.btnSettings.setOnClickListener(MenuClickHelper.getSettingsClickListener(this));
    }
}

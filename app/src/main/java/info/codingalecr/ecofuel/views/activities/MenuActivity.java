package info.codingalecr.ecofuel.views.activities;

import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityMenuBinding;
import info.codingalecr.ecofuel.helpers.MenuClickHelper;
import info.codingalecr.ecofuel.views.base.BaseActivity;

public class MenuActivity extends BaseActivity {

    @Override
    public void initObj() {
        getBinding().btnFuelList.setOnClickListener(MenuClickHelper.getRefuelListClickListener(this));
        getBinding().btnSettings.setOnClickListener(MenuClickHelper.getSettingsClickListener(this));
    }

    @Override
    public void initUI() {

    }

    @Override
    public boolean withToolbar() {
        return true;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_menu;
    }

    @Override
    public ActivityMenuBinding getBinding() {
        return (ActivityMenuBinding) getBaseBinding();
    }
}

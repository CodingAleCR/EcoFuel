package info.codingalecr.ecofuel.views.activities;

import info.codingalecr.ecofuel.DateUtils;
import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityRefuelDetailBinding;
import info.codingalecr.ecofuel.models.MFuelItem;
import info.codingalecr.ecofuel.views.base.BaseActivity;

/**
 * Created by aulate on 18/12/17.
 */

public class RefuelDetailActivity extends BaseActivity {

    @Override
    public boolean withToolbar() {
        return false;
    }

    @Override
    public void initObj() {

    }

    @Override
    public void initUI() {
        MFuelItem item = (MFuelItem) getIntent().getSerializableExtra("ITEM");
        MFuelItem previous = (MFuelItem) getIntent().getSerializableExtra("PREVIOUS");
        getBinding().setItem(item);

        getBinding().refuelDaysSince.setText(String.valueOf(DateUtils.showDate(previous.getFuelingDate())));
        getBinding().refuelPerformance.setText(String.valueOf(item.getPerformance(previous.getKilometers())));
        getBinding().refuelDistance.setText(String.valueOf(item.getKilometerDifference(previous.getKilometers())));
        getBinding().refuelPricePerLiter.setText(String.valueOf(item.priceByLiter()));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_refuel_detail;
    }

    @Override
    public ActivityRefuelDetailBinding getBinding() {
        return (ActivityRefuelDetailBinding) getBaseBinding();
    }
}

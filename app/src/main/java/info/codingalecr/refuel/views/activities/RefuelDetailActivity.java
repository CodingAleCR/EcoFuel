package info.codingalecr.refuel.views.activities;

import android.view.View;

import info.codingalecr.refuel.BindingUtils;
import info.codingalecr.refuel.Contracts;
import info.codingalecr.refuel.R;
import info.codingalecr.refuel.databinding.ActivityRefuelDetailBinding;
import info.codingalecr.refuel.models.MFuelItem;
import info.codingalecr.refuel.views.base.BaseActivity;

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
        MFuelItem item = (MFuelItem) getIntent().getSerializableExtra(Contracts.REFUEL_DETAIL_ACTIVITY.ITEM);
        if (item != null) {
            getBinding().usage.setVisibility(View.VISIBLE);
            getBinding().usageSubtitle.setVisibility(View.VISIBLE);
            getBinding().setItem(item);
            BindingUtils.showCash(getBinding().refuelPricePerLiter, item.priceByLiter());
        } else {
            getBinding().usage.setVisibility(View.GONE);
            getBinding().usageSubtitle.setVisibility(View.GONE);
        }

        MFuelItem previous = (MFuelItem) getIntent().getSerializableExtra(Contracts.REFUEL_DETAIL_ACTIVITY.PREVIOUS);
        if (previous != null) {
            getBinding().analysis.setVisibility(View.VISIBLE);
            getBinding().analysisSubtitle.setVisibility(View.VISIBLE);
            BindingUtils.showDaysDifference(getBinding().refuelDaysSince, previous.getFuelingDate(), item.getFuelingDate());
            BindingUtils.showPerformance(getBinding().refuelPerformance, item.getPerformance(previous.getKilometers()));
            BindingUtils.showKilometers(getBinding().refuelDistance, item.getKilometerDifference(previous.getKilometers()));
        } else {
            getBinding().analysis.setVisibility(View.GONE);
            getBinding().analysisSubtitle.setVisibility(View.GONE);
        }
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

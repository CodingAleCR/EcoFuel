package info.codingalecr.ecofuel.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.util.Date;

import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityFuelItemFormBinding;
import info.codingalecr.ecofuel.models.MFuelItem;

public class FuelItemFormActivity extends AppCompatActivity {

    private ActivityFuelItemFormBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fuel_item_form);

        Date now = new Date();
        mBinding.datePicker.init(now.getYear(), now.getMonth(), now.getDay(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                mBinding.getRefuel().setFuelingDate(new Date(year, monthOfYear, dayOfMonth));
            }
        });
    }

    public void getRefuel(View view) {
        MFuelItem item = mBinding.getRefuel();
        Log.d("obj", item.toString());
    }
}

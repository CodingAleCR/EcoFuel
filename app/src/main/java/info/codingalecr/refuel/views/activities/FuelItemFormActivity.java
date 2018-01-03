package info.codingalecr.refuel.views.activities;

import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

import info.codingalecr.refuel.R;
import info.codingalecr.refuel.databinding.ActivityFuelItemFormBinding;
import info.codingalecr.refuel.models.MFuelItem;
import info.codingalecr.refuel.views.base.BaseActivity;

public class FuelItemFormActivity extends BaseActivity {

    private DatabaseReference mDatabase;

    @Override
    public boolean withToolbar() {
        return false;
    }

    @Override
    public void initObj() {
        mDatabase = FirebaseDatabase.getInstance().getReference("refuels");
    }

    @Override
    public void initUI() {
        clearForm();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_fuel_item_form;
    }

    @Override
    public ActivityFuelItemFormBinding getBinding() {
        return (ActivityFuelItemFormBinding) getBaseBinding();
    }

    public void addRefuel(View view) {
        MFuelItem item = new MFuelItem();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, getBinding().datePickerRefuelDate.getYear());
        calendar.set(Calendar.MONTH, getBinding().datePickerRefuelDate.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, getBinding().datePickerRefuelDate.getDayOfMonth());

        item.setAmountCash(Float.parseFloat(getBinding().textInputCash.getEditText().getText().toString()));
        item.setAmountLt(Float.parseFloat(getBinding().textInputLiters.getEditText().getText().toString()));
        item.setKilometers(Float.parseFloat(getBinding().textInputKilometers.getEditText().getText().toString()));
        DatabaseReference newRefuel = mDatabase.push();
        newRefuel.setValue(item, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    clearForm();
                    Toast.makeText(FuelItemFormActivity.this, "", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void clearForm() {
        getBinding().textInputCash.getEditText().setText(null);
        getBinding().textInputLiters.getEditText().setText(null);
        getBinding().textInputKilometers.getEditText().setText(null);
        clearDatePicker();
    }

    public void clearDatePicker() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        getBinding().datePickerRefuelDate.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);
    }
}

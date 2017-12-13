package info.codingalecr.ecofuel.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityFuelItemFormBinding;
import info.codingalecr.ecofuel.models.MFuelItem;

public class FuelItemFormActivity extends AppCompatActivity {

    private ActivityFuelItemFormBinding mBinding;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fuel_item_form);
        mDatabase = FirebaseDatabase.getInstance().getReference("refuels");

        clearForm();
    }

    public void addRefuel(View view) {
        MFuelItem item = new MFuelItem();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, mBinding.datePickerRefuelDate.getYear());
        calendar.set(Calendar.MONTH, mBinding.datePickerRefuelDate.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, mBinding.datePickerRefuelDate.getDayOfMonth());

        item.setAmountCash(Float.parseFloat(mBinding.textInputCash.getEditText().getText().toString()));
        item.setAmountLt(Float.parseFloat(mBinding.textInputLiters.getEditText().getText().toString()));
        item.setKilometers(Float.parseFloat(mBinding.textInputKilometers.getEditText().getText().toString()));
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
        mBinding.textInputCash.getEditText().setText(null);
        mBinding.textInputLiters.getEditText().setText(null);
        mBinding.textInputKilometers.getEditText().setText(null);
        clearDatePicker();
    }

    public void clearDatePicker() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        mBinding.datePickerRefuelDate.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);
    }
}

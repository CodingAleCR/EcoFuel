package info.codingalecr.ecofuel.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.codingalecr.ecofuel.ItemClickListener;
import info.codingalecr.ecofuel.ProgressConductor;
import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityRefuelListBinding;
import info.codingalecr.ecofuel.helpers.MainClickHelper;
import info.codingalecr.ecofuel.models.MFuelItem;
import info.codingalecr.ecofuel.views.adapters.FuelItemAdapter;

public class FuelListActivity extends AppCompatActivity implements ItemClickListener, ProgressConductor {

    private ActivityRefuelListBinding mBinding;

    private FuelItemAdapter mFuelAdapter;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_refuel_list);
        init();
    }

    public void init() {
        mFuelAdapter = new FuelItemAdapter();
        mDatabase = FirebaseDatabase.getInstance().getReference("refuels");

        mFuelAdapter.setItemClickListener(this);
        mFuelAdapter.setProgressConductor(this);
        mBinding.fabAdd.setOnClickListener(MainClickHelper.getNewFuelItemClickListener(this));
        showRefuelList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDatabase.orderByChild("fuelingDate").addValueEventListener(mFuelAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.orderByChild("fuelingDate").removeEventListener(mFuelAdapter);
    }

    public void showRefuelList() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mBinding.fuelList.setLayoutManager(manager);
        mBinding.fuelList.setAdapter(mFuelAdapter);
        mFuelAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(int viewId, int position, boolean isLongClick) {
        MFuelItem item = mFuelAdapter.getItem(position);
        Toast.makeText(this, item.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        mBinding.progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mBinding.progress.setVisibility(View.GONE);
    }
}

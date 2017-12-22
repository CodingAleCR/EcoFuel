package info.codingalecr.ecofuel.views.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.codingalecr.ecofuel.Contracts;
import info.codingalecr.ecofuel.ItemClickListener;
import info.codingalecr.ecofuel.ProgressConductor;
import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityRefuelListBinding;
import info.codingalecr.ecofuel.helpers.MainClickHelper;
import info.codingalecr.ecofuel.models.MFuelItem;
import info.codingalecr.ecofuel.views.adapters.FuelItemAdapter;
import info.codingalecr.ecofuel.views.base.BaseActivity;

public class FuelListActivity extends BaseActivity implements ItemClickListener, ProgressConductor {

    private FuelItemAdapter mFuelAdapter;

    private DatabaseReference mDatabase;

    @Override
    public boolean withToolbar() {
        return false;
    }

    @Override
    public void initObj() {
        mFuelAdapter = FuelItemAdapter.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("refuels");

        mFuelAdapter.setItemClickListener(this);
        mFuelAdapter.setProgressConductor(this);
        getBinding().fabAdd.setOnClickListener(MainClickHelper.getNewFuelItemClickListener(this));
    }

    @Override
    public void initUI() {
        showRefuelList();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_refuel_list;
    }

    @Override
    public ActivityRefuelListBinding getBinding() {
        return (ActivityRefuelListBinding) getBaseBinding();
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
        getBinding().fuelList.setLayoutManager(manager);
        getBinding().fuelList.setAdapter(mFuelAdapter);
        mFuelAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(int viewId, int position, boolean isLongClick) {
        MFuelItem item = mFuelAdapter.getItem(position);
        MFuelItem previous = position < mFuelAdapter.getItemCount() ? mFuelAdapter.getItem(position + 1) : null;
        Intent toDetail = new Intent(this, RefuelDetailActivity.class);
        toDetail.putExtra(Contracts.REFUEL_DETAIL_ACTIVITY.ITEM, item);
        toDetail.putExtra(Contracts.REFUEL_DETAIL_ACTIVITY.PREVIOUS, previous);

        startActivity(toDetail);
    }

    @Override
    public void showProgress() {
        getBinding().progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        getBinding().progress.setVisibility(View.GONE);
    }
}

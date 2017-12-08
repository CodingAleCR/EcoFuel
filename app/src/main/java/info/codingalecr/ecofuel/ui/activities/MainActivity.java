package info.codingalecr.ecofuel.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import info.codingalecr.ecofuel.ItemClickListener;
import info.codingalecr.ecofuel.ProgressConductor;
import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityMainBinding;
import info.codingalecr.ecofuel.helpers.MainClickHelper;
import info.codingalecr.ecofuel.models.MFuelItem;
import info.codingalecr.ecofuel.ui.adapters.FuelItemAdapter;

public class MainActivity extends AppCompatActivity implements ItemClickListener, ProgressConductor {

    private ActivityMainBinding mBinding;

    private FuelItemAdapter mFuelAdapter;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

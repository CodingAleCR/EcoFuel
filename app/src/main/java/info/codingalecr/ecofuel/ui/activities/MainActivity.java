package info.codingalecr.ecofuel.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.databinding.ActivityMainBinding;
import info.codingalecr.ecofuel.helpers.MainClickHelper;
import info.codingalecr.ecofuel.models.MFuelItem;
import info.codingalecr.ecofuel.ui.adapters.FuelItemAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    private FuelItemAdapter mFuelAdapter;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBinding.fabAdd.setOnClickListener(MainClickHelper.getNewFuelItemClickListener(this));

        mFuelAdapter = new FuelItemAdapter();

        mDatabase = FirebaseDatabase.getInstance().getReference("refuels");

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
        mDatabase.addChildEventListener(mFuelAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.removeEventListener(mFuelAdapter);
    }

    public void showRefuelList() {
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<MFuelItem> items = new ArrayList<MFuelItem>();
                for (DataSnapshot item :
                        dataSnapshot.getChildren()) {
                    MFuelItem fuelItem = item.getValue(MFuelItem.class);
                    items.add(fuelItem);
                }
                mFuelAdapter.setFuelItems(items);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("", "");
            }
        });
    }
}

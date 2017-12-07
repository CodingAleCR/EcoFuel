package info.codingalecr.ecofuel.ui.adapters;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.models.MFuelItem;

/**
 * Created by aulate on 30/11/17.
 */

public class FuelItemAdapter extends BaseAdapter implements ValueEventListener {

    private List<MFuelItem> mFuelItems;

    public FuelItemAdapter() {
        mFuelItems = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mFuelItems.size();
    }

    @Override
    public MFuelItem getItem(int position) {
        if (!mFuelItems.isEmpty() && position != -1 && position < mFuelItems.size()) {
            return mFuelItems.get(position);
        }
        return null;
    }

    @Override
    protected int getLayoutForPosition(int position) {
        return R.layout.fuel_item;
    }

    public void setFuelItems(List<MFuelItem> mFuelItems) {
        this.mFuelItems = mFuelItems;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<MFuelItem> items = new ArrayList<>();
        for (DataSnapshot item :
                dataSnapshot.getChildren()) {
            MFuelItem fuelItem = item.getValue(MFuelItem.class);
            items.add(fuelItem);
        }
        setFuelItems(items);
        notifyDataSetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.i("Database", databaseError.getMessage());
    }
}

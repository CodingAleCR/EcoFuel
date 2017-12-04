package info.codingalecr.ecofuel.ui.adapters;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

import info.codingalecr.ecofuel.R;
import info.codingalecr.ecofuel.models.MFuelItem;

/**
 * Created by aulate on 30/11/17.
 */

public class FuelItemAdapter extends BaseAdapter implements ChildEventListener {

    private List<MFuelItem> mFuelItems;

    public FuelItemAdapter() {
        mFuelItems = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mFuelItems.size();
    }

    @Override
    protected MFuelItem getObjForPosition(int position) {
        if (!mFuelItems.isEmpty() && position != -1 && position < mFuelItems.size()) {
            return mFuelItems.get(position);
        }
        return null;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.fuel_item;
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        MFuelItem item = dataSnapshot.getValue(MFuelItem.class);
        mFuelItems.add(item);
        notifyItemInserted(mFuelItems.indexOf(item));
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        MFuelItem item = dataSnapshot.getValue(MFuelItem.class);

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        MFuelItem item = dataSnapshot.getValue(MFuelItem.class);
        mFuelItems.remove(item);
        notifyItemRemoved(mFuelItems.indexOf(item));
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        MFuelItem item = dataSnapshot.getValue(MFuelItem.class);
//        notify
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.e("sl_FuelItemAdapter", databaseError.getMessage());
        //Do nothing
    }


    public void setFuelItems(List<MFuelItem> mFuelItems) {
        this.mFuelItems = mFuelItems;
    }
}

package info.codingalecr.ecofuel.ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import info.codingalecr.ecofuel.ui.BindedViewHolder;

/**
 * Created by aulate on 4/12/17.
 */

public abstract class BaseAdapter
        extends RecyclerView.Adapter<BindedViewHolder> {
    public BindedViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new BindedViewHolder(binding);
    }

    public void onBindViewHolder(BindedViewHolder holder,
                                 int position) {
        Object obj = getObjForPosition(position);
        holder.bind(obj);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);
}

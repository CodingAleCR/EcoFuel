package info.codingalecr.refuel.views.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.codingalecr.refuel.ItemClickListener;

/**
 * Created by aulate on 4/12/17.
 */

public abstract class BaseAdapter
        extends RecyclerView.Adapter<BindedViewHolder> {

    private ItemClickListener mItemClickListener;

    public BindedViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new BindedViewHolder(binding);
    }

    public void onBindViewHolder(final BindedViewHolder holder,
                                 int position) {
        Object obj = getItem(position);
        holder.bind(obj);
        if (mItemClickListener != null) {
            holder.getView().setClickable(true);
            holder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClicked(view.getId(), holder.getAdapterPosition(), false);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutForPosition(position);
    }

    public abstract Object getItem(int position);

    protected abstract int getLayoutForPosition(int position);

    public ItemClickListener getItemClickListener() {
        return mItemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}

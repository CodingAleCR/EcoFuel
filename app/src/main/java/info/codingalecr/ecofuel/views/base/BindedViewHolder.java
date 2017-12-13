package info.codingalecr.ecofuel.views.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import info.codingalecr.ecofuel.BR;

/**
 * Created by aulate on 4/12/17.
 */

public class BindedViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding mBinding;
    private final View mView;

    public BindedViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.mView = binding.getRoot();
        this.mBinding = binding;
    }

    public void bind(Object obj) {
        mBinding.setVariable(BR.item, obj);
        mBinding.executePendingBindings();
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    public View getView() {
        return mView;
    }
}

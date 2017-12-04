package info.codingalecr.ecofuel.ui;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import info.codingalecr.ecofuel.BR;

/**
 * Created by aulate on 4/12/17.
 */

public class BindedViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public BindedViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.obj, obj);
        binding.executePendingBindings();
    }
}

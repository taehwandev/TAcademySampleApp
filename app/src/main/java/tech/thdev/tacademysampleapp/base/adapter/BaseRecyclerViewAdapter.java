package tech.thdev.tacademysampleapp.base.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tech.thdev.tacademysampleapp.base.adapter.holder.BaseViewHolder;
import tech.thdev.tacademysampleapp.base.adapter.viewmodel.BaseAdapterViewModel;

public abstract class BaseRecyclerViewAdapter<VIEW_MODEL extends BaseAdapterViewModel> extends RecyclerView.Adapter<BaseViewHolder<Object, VIEW_MODEL>> {

    VIEW_MODEL viewModel;

    public BaseRecyclerViewAdapter(@NonNull VIEW_MODEL viewModel) {
        super();
        this.viewModel = viewModel;

        init();
    }

    /**
     * ViewModel의 화면 갱신을 초기화
     */
    private void init() {
        viewModel.setNotifyItemChanged(new Function1<Integer, Unit>() {
            @Override
            public Unit invoke(Integer integer) {
                notifyItemChanged(integer);
                return null;
            }
        });

        viewModel.setNotifyDataSetChanged(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                notifyDataSetChanged();
                return null;
            }
        });
    }

    @NonNull
    @Override
    public BaseViewHolder<Object, VIEW_MODEL> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createViewHolder(viewType, parent);
    }

    protected abstract BaseViewHolder<Object, VIEW_MODEL> createViewHolder(int viewType, @NonNull ViewGroup parent);

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<Object, VIEW_MODEL> holder, int position) {
        holder.checkItemAndBindViewHolder(viewModel.getAdapterRepository().getItem(position));
    }

    @Override
    public int getItemCount() {
        return viewModel.getAdapterRepository().getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return viewModel.getAdapterRepository().getItemViewType(position);
    }
}

package ru.example.beautysalon.ui.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.data.models.TimeModel;

public class TimeAdapter extends ListAdapter<TimeModel, TimeViewHolder> {

    private ServiceAdapter.OnItemClickListener listener;

    public TimeAdapter(@NonNull DiffUtil.ItemCallback<TimeModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TimeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {
        TimeModel current = getItem(position);
        holder.bind(current.getTime());
        holder.itemView.setOnClickListener(view -> {
            listener.onItemClick(view, position);
        });
    }

    public void setOnItemClickListener(ServiceAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public static class ItemTimeDiff extends DiffUtil.ItemCallback<TimeModel> {

        @Override
        public boolean areItemsTheSame(@NonNull TimeModel oldItem, @NonNull TimeModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull TimeModel oldItem, @NonNull TimeModel newItem) {
            return (oldItem.getTime().equals(newItem.getTime()));
        }
    }
}

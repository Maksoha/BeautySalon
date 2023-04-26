package ru.example.beautysalon.ui.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.data.models.ServiceModel;


public class ServiceAdapter extends ListAdapter<ServiceModel, ServiceViewHolder>  {
    private OnItemClickListener listener;

    public ServiceAdapter(@NonNull DiffUtil.ItemCallback<ServiceModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ServiceViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        ServiceModel current = getItem(position);
        holder.bind(current.getName(), current.getPrice());
        holder.itemView.setOnClickListener(view -> {
            listener.onItemClick(view, position);
        });
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    public static class ServiceDiff extends DiffUtil.ItemCallback<ServiceModel> {

        @Override
        public boolean areItemsTheSame(@NonNull ServiceModel oldItem, @NonNull ServiceModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ServiceModel oldItem, @NonNull ServiceModel newItem) {
            return (oldItem.getName().equals(newItem.getName())
            && oldItem.getPrice() == newItem.getPrice());
        }
    }

}

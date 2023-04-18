package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.data.models.TypeServiceModel;

public class ServiceAdapter extends ListAdapter<ServiceModel, ServiceViewHolder> {

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

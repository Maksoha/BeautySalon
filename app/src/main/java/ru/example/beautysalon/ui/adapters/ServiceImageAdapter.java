package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.PhotoModel;
import ru.example.beautysalon.data.models.ServiceImageModel;
import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.data.models.SpecialistModel;

public class ServiceImageAdapter extends ListAdapter<ServiceImageModel, ServiceImageViewHolder> {

    private ServiceImageAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ServiceImageModel serviceImageModel);
    }

    public ServiceImageAdapter(@NonNull DiffUtil.ItemCallback<ServiceImageModel> diffCallback) {
        super(diffCallback);

    }

    @NonNull
    @Override
    public ServiceImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ServiceImageViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceImageViewHolder holder, int position) {
        ServiceImageModel current = getItem(position);
        holder.bind(current.getImageResourceId(), current.getName(), current.getPrice());

    }

    public void setOnItemClickListener(ServiceImageAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ServiceImageDiff extends DiffUtil.ItemCallback<ServiceImageModel> {

        @Override
        public boolean areItemsTheSame(@NonNull ServiceImageModel oldItem, @NonNull ServiceImageModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ServiceImageModel oldItem, @NonNull ServiceImageModel newItem) {
            return oldItem.getImageResourceId() == newItem.getImageResourceId() &&
                    oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getPrice() == newItem.getPrice();
        }
    }
}

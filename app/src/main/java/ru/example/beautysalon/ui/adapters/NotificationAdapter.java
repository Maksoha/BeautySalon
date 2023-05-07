package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.data.models.NotificationModel;

public class NotificationAdapter extends ListAdapter<NotificationModel, NotificationViewHolder> {

    public NotificationAdapter(@NonNull DiffUtil.ItemCallback<NotificationModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NotificationViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationModel current = getItem(position);
        holder.bind(current.getDate(), current.getTitle(), current.getDescription());
    }

    public static class NotificationDiff extends DiffUtil.ItemCallback<NotificationModel> {

        @Override
        public boolean areItemsTheSame(@NonNull NotificationModel oldItem, @NonNull NotificationModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull NotificationModel oldItem, @NonNull NotificationModel newItem) {
            return oldItem.getDate().equals(newItem.getDate()) && oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDescription().equals(newItem.getDescription());
        }
    }
}

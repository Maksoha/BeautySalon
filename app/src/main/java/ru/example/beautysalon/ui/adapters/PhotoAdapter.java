package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

import ru.example.beautysalon.data.models.PhotoModel;

public class PhotoAdapter extends ListAdapter<PhotoModel, PhotoViewHolder> {

    public PhotoAdapter(@NonNull DiffUtil.ItemCallback<PhotoModel> diffCallback) {
        super(diffCallback);

    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PhotoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoModel current = getItem(position);
        holder.bind(current.getImageResourceId());
    }

    public static class PhotoDiff extends DiffUtil.ItemCallback<PhotoModel> {

        @Override
        public boolean areItemsTheSame(@NonNull PhotoModel oldItem, @NonNull PhotoModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull PhotoModel oldItem, @NonNull PhotoModel newItem) {
            return oldItem.getImageResourceId() == newItem.getImageResourceId();
        }
    }
}

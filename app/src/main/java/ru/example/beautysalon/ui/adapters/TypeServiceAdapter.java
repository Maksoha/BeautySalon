package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.List;

import ru.example.beautysalon.data.models.TypeServiceModel;

public class TypeServiceAdapter extends ListAdapter<TypeServiceModel, TypeServiceViewHolder> {

    public TypeServiceAdapter(@NonNull DiffUtil.ItemCallback<TypeServiceModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TypeServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TypeServiceViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeServiceViewHolder holder, int position) {
        TypeServiceModel current = getItem(position);
        holder.bind(current.getText());
    }

    public static class TypeServiceDiff extends DiffUtil.ItemCallback<TypeServiceModel> {

        @Override
        public boolean areItemsTheSame(@NonNull TypeServiceModel oldItem, @NonNull TypeServiceModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull TypeServiceModel oldItem, @NonNull TypeServiceModel newItem) {
            return (oldItem.getText().equals(newItem.getText()));
        }
    }
}

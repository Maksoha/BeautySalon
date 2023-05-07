package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.data.models.CardSaleModel;

public class SaleCenteredAdapter extends ListAdapter<CardSaleModel, SaleCenteredViewHolder> {

    public SaleCenteredAdapter(@NonNull DiffUtil.ItemCallback<CardSaleModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public SaleCenteredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SaleCenteredViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleCenteredViewHolder holder, int position) {
        CardSaleModel current = getItem(position);
        holder.bind(current.getText());
    }

    public static class SaleDiff extends DiffUtil.ItemCallback<CardSaleModel> {

        @Override
        public boolean areItemsTheSame(@NonNull CardSaleModel oldItem, @NonNull CardSaleModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CardSaleModel oldItem, @NonNull CardSaleModel newItem) {
            return oldItem.getText().equals(newItem.getText());
        }
    }
}

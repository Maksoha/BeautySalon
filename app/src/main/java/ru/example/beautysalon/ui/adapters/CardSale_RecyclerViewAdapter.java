package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautysalontest.R;
import com.example.beautysalontest.databinding.CardSaleBinding;

import ru.example.beautysalon.data.models.CardSaleModel;

import java.util.ArrayList;
import java.util.List;

public class CardSale_RecyclerViewAdapter extends RecyclerView.Adapter<CardSale_RecyclerViewAdapter.CardSale_RecyclerViewViewHolder> {
    List<CardSaleModel> data;

    public CardSale_RecyclerViewAdapter() {
        this.data = new ArrayList<>();
    }

    public void updateData(List<CardSaleModel> newData) {
        data = newData;

        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CardSale_RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardSaleBinding binding = CardSaleBinding.inflate(LayoutInflater.from(parent.getContext()));

        return new CardSale_RecyclerViewViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CardSale_RecyclerViewViewHolder holder, int position) {
        holder.binding.elevationText.setText(data.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class CardSale_RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        public CardSaleBinding binding;

        public CardSale_RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = CardSaleBinding.bind(itemView);
        }
    }
}

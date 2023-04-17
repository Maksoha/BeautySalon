package ru.example.beautysalon.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautysalontest.databinding.CardSpecialistBinding;

import ru.example.beautysalon.data.models.CardSpecialistModel;

import java.util.ArrayList;
import java.util.List;

public class CardSpecialist_RecyclerViewAdapter extends RecyclerView.Adapter<CardSpecialist_RecyclerViewAdapter.CardSpecialist_RecyclerViewViewHolder> {

    private List<CardSpecialistModel> data;

    public CardSpecialist_RecyclerViewAdapter() {
        this.data = new ArrayList<>();
    }

    public void updateData(List<CardSpecialistModel> newData) {
        this.data = newData;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardSpecialist_RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardSpecialistBinding binding = CardSpecialistBinding.inflate(LayoutInflater.from(parent.getContext()));

        return new CardSpecialist_RecyclerViewViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CardSpecialist_RecyclerViewViewHolder holder, int position) {
        holder.binding.specialistCardName.setText(data.get(position).getName());
        holder.binding.specialistCardSpeciality.setText(data.get(position).getSpeciality());
        holder.binding.specialistCardTextAvatar.setText(data.get(position).getName().substring(0,1));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CardSpecialist_RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        public CardSpecialistBinding binding;

        public CardSpecialist_RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = CardSpecialistBinding.bind(itemView);
        }
    }
}

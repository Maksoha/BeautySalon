package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautysalontest.databinding.CardServiceBinding;

import java.util.ArrayList;
import java.util.List;

import ru.example.beautysalon.data.models.TypeServiceModel;

public class Service_RecyclerViewAdapter extends RecyclerView.Adapter<Service_RecyclerViewAdapter.CardService_RecyclerViewViewHolder> {

    private List<TypeServiceModel> data;

    public Service_RecyclerViewAdapter() {
        this.data = new ArrayList<>();
    }

    public void updateData(List<TypeServiceModel> newData) {
        data = newData;

        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CardService_RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardServiceBinding binding = CardServiceBinding.inflate(LayoutInflater.from(parent.getContext()));

        return new CardService_RecyclerViewViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CardService_RecyclerViewViewHolder holder, int position) {
        holder.binding.cardServiceText.setText(data.get(position+1).getText());
    }

    @Override
    public int getItemCount() {
        return data.size() - 1;
    }

    static class CardService_RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        private CardServiceBinding binding;

        public CardService_RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = CardServiceBinding.bind(itemView);
        }
    }
}

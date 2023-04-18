package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautysalontest.databinding.CardSaleBinding;

public class SaleViewHolder extends RecyclerView.ViewHolder {

    private CardSaleBinding binding;

    public SaleViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = CardSaleBinding.bind(itemView);
    }

    public void bind (String text) {
        binding.elevationText.setText(text);
    }

    static SaleViewHolder create(ViewGroup parent) {
        CardSaleBinding mBinding = CardSaleBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new SaleViewHolder(view);
    }
}


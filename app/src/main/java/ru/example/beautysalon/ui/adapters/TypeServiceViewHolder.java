package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.beautysalon.databinding.CardTypeServiceBinding;


public class TypeServiceViewHolder extends RecyclerView.ViewHolder {

    private CardTypeServiceBinding binding;

    public TypeServiceViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = CardTypeServiceBinding.bind(itemView);
    }

    public void bind (String text) {
        binding.cardServiceText.setText(text);
    }

    static TypeServiceViewHolder create(ViewGroup parent) {
        CardTypeServiceBinding mBinding = CardTypeServiceBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new TypeServiceViewHolder(view);
    }
}


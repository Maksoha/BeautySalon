package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.beautysalon.databinding.CardSaleCenteredBinding;

public class SaleCenteredViewHolder extends RecyclerView.ViewHolder {
    private CardSaleCenteredBinding binding;

    public SaleCenteredViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = CardSaleCenteredBinding.bind(itemView);
    }

    public void bind (String text) {
        binding.elevationText.setText(text);
    }

    static SaleCenteredViewHolder create(ViewGroup parent) {
        CardSaleCenteredBinding mBinding = CardSaleCenteredBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new SaleCenteredViewHolder(view);
    }
}

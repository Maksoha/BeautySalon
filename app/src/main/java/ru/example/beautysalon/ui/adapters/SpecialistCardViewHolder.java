package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import ru.example.beautysalon.databinding.ItemSpecialistBinding;

public class SpecialistCardViewHolder extends RecyclerView.ViewHolder {

    private ItemSpecialistBinding binding;

    public SpecialistCardViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = ItemSpecialistBinding.bind(itemView);
    }

    public void bind (String text_avatar, String name, String speciality) {
        binding.textAvatar.setText(text_avatar);
        binding.name.setText(name);
        binding.speciality.setText(speciality);
    }

    static SpecialistCardViewHolder create(ViewGroup parent) {
        ItemSpecialistBinding mBinding = ItemSpecialistBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new SpecialistCardViewHolder(view);
    }
}

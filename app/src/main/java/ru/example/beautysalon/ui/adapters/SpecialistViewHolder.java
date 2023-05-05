package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.beautysalon.databinding.CardSpecialistBinding;

public class SpecialistViewHolder extends RecyclerView.ViewHolder {
    private CardSpecialistBinding binding;

    public SpecialistViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = CardSpecialistBinding.bind(itemView);
    }

    public void bind (String text_avatar, String name, String speciality) {
        binding.specialistCardTextAvatar.setText(text_avatar);
        binding.specialistCardName.setText(name);
        binding.specialistCardSpeciality.setText(speciality);
    }

    static SpecialistViewHolder create(ViewGroup parent) {
        CardSpecialistBinding mBinding = CardSpecialistBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new SpecialistViewHolder(view);
    }
}

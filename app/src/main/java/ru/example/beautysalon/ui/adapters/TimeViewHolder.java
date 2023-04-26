package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautysalontest.databinding.CardTypeServiceBinding;
import com.example.beautysalontest.databinding.ItemTimeBinding;

public class TimeViewHolder extends RecyclerView.ViewHolder {

    private ItemTimeBinding binding;

    public TimeViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = ItemTimeBinding.bind(itemView);
    }

    public void bind(String time) {
        binding.itemTime.setText(time);
    }

    static TimeViewHolder create (ViewGroup parent) {
        ItemTimeBinding mBinding = ItemTimeBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new TimeViewHolder(view);
    }
}
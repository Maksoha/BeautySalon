package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.beautysalon.databinding.ItemNotificationBinding;

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    private ItemNotificationBinding binding;

    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = ItemNotificationBinding.bind(itemView);
    }

    public void bind (String date, String title, String description) {
        binding.date.setText(date);
        binding.title.setText(title);
        binding.description.setText(description);
    }

    static NotificationViewHolder create(ViewGroup parent) {
        ItemNotificationBinding mBinding = ItemNotificationBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new NotificationViewHolder(view);
    }
}

package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.beautysalon.databinding.ItemServicesBinding;

public class ServiceImageViewHolder extends RecyclerView.ViewHolder {

    private ItemServicesBinding binding;

    public ServiceImageViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = ItemServicesBinding.bind(itemView);
    }

    public void bind (int imageResourceId, String serviceName, int price) {
        binding.image.setImageResource(imageResourceId);
        binding.serviceName.setText(serviceName);
        binding.price.setText(price + " руб.");
    }

    static ServiceImageViewHolder create(ViewGroup parent) {
        ItemServicesBinding mBinding = ItemServicesBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new ServiceImageViewHolder(view);
    }
}

package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.example.beautysalon.databinding.ItemPhotoBinding;

public class PhotoViewHolder extends RecyclerView.ViewHolder {
    private ItemPhotoBinding binding;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = ItemPhotoBinding.bind(itemView);
    }

    public void bind (int imageResourceId) {
        binding.image.setImageResource(imageResourceId);
    }

    static PhotoViewHolder create(ViewGroup parent) {
        ItemPhotoBinding mBinding = ItemPhotoBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = mBinding.getRoot();
        return new PhotoViewHolder(view);
    }
}

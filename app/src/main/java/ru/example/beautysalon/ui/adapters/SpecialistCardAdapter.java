package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.data.models.SpecialistModel;

public class SpecialistCardAdapter extends ListAdapter<SpecialistModel, SpecialistCardViewHolder> {

    public SpecialistCardAdapter(@NonNull DiffUtil.ItemCallback<SpecialistModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public SpecialistCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SpecialistCardViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialistCardViewHolder holder, int position) {
        SpecialistModel current = getItem(position);
        holder.bind(current.getName().substring(0, 1), current.getName(), current.getSpeciality());
    }

    public static class SpecialistCardDiff extends DiffUtil.ItemCallback<SpecialistModel> {

        @Override
        public boolean areItemsTheSame(@NonNull SpecialistModel oldItem, @NonNull SpecialistModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull SpecialistModel oldItem, @NonNull SpecialistModel newItem) {
            return (oldItem.getName().equals(newItem.getName())
                    && oldItem.getSpeciality().equals(newItem.getSpeciality()));
        }
    }
}

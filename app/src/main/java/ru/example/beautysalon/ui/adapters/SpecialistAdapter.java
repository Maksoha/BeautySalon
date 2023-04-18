package ru.example.beautysalon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautysalontest.databinding.CardSpecialistBinding;

import ru.example.beautysalon.data.models.CardSpecialistModel;
import ru.example.beautysalon.data.models.TypeServiceModel;

import java.util.ArrayList;
import java.util.List;

public class SpecialistAdapter extends ListAdapter<CardSpecialistModel, SpecialistViewHolder> {

    public SpecialistAdapter(@NonNull DiffUtil.ItemCallback<CardSpecialistModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public SpecialistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SpecialistViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialistViewHolder holder, int position) {
        CardSpecialistModel current = getItem(position);
        holder.bind(current.getName().substring(0, 1), current.getName(), current.getSpeciality());
    }

    public static class SpecialistDiff extends DiffUtil.ItemCallback<CardSpecialistModel> {

        @Override
        public boolean areItemsTheSame(@NonNull CardSpecialistModel oldItem, @NonNull CardSpecialistModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CardSpecialistModel oldItem, @NonNull CardSpecialistModel newItem) {
            return (oldItem.getName().equals(newItem.getName())
            && oldItem.getSpeciality().equals(newItem.getSpeciality()));
        }
    }
}

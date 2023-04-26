package ru.example.beautysalon.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ru.example.beautysalon.data.models.SpecialistModel;

public class SpecialistAdapter extends ListAdapter<SpecialistModel, SpecialistViewHolder> {
    private ServiceAdapter.OnItemClickListener listener;

    public SpecialistAdapter(@NonNull DiffUtil.ItemCallback<SpecialistModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public SpecialistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return SpecialistViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialistViewHolder holder, int position) {
        SpecialistModel current = getItem(position);
        holder.bind(current.getName().substring(0, 1), current.getName(), current.getSpeciality());
        holder.itemView.setOnClickListener(view -> {
            listener.onItemClick(view, position);
        });
    }

    public void setOnItemClickListener(ServiceAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }


    public static class SpecialistDiff extends DiffUtil.ItemCallback<SpecialistModel> {

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

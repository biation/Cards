package com.example.card.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.card.databinding.ItemImageBinding;
import com.example.card.model.Hit;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    ArrayList<Hit> list;

   ItemImageBinding binding;

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ImageHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<Hit> list) {
        this.list = list;
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        public ImageHolder(ItemImageBinding binding) {
            super(binding.getRoot());
        }

        public void onBind(Hit hit) {
            Glide.with(binding.imageV).load(hit.getLargeImageURL()).into(binding.imageV);
        }
    }
}

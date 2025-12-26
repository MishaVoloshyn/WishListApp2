package com.example.wishlistapp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishAdapter extends RecyclerView.Adapter<WishAdapter.VH> {

    public interface OnCheckedChanged {
        void onChanged();
    }

    private final List<WishItem> items;
    private final OnCheckedChanged listener;

    public WishAdapter(List<WishItem> items, OnCheckedChanged listener) {
        this.items = items;
        this.listener = listener;
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtName, txtPrice;
        CheckBox check;

        public VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            check = itemView.findViewById(R.id.check);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wish, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        WishItem item = items.get(position);

        holder.img.setImageResource(item.imageRes);
        holder.txtName.setText(item.name);
        holder.txtPrice.setText(item.price + " грн");

        // чтобы не срабатывал старый listener при переиспользовании
        holder.check.setOnCheckedChangeListener(null);
        holder.check.setChecked(item.checked);

        holder.check.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.checked = isChecked;
            if (listener != null) listener.onChanged();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

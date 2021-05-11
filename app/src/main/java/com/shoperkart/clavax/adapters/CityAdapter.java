package com.shoperkart.clavax.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shoperkart.clavax.R;
import com.shoperkart.clavax.interfaces.Interfaces;
import com.shoperkart.clavax.models.ZipCode;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private final Context context;
    private final Interfaces.RVItemOnClick onClick;
    private List<ZipCode> list;

    public CityAdapter(Context context, List<ZipCode> list, Interfaces.RVItemOnClick onClick) {
        this.context = context;
        this.list = list;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.zipcode_layout, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.CityViewHolder holder, int position) {
        holder.zipCode.setText(String.valueOf(list.get(position).getZipcode()));
        holder.itemView.setOnClickListener(v -> onClick.onZipCodeClick(list.get(position).getZipcode()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filteredList(List<ZipCode> filteredList) {
        this.list = filteredList;
        notifyDataSetChanged();
    }

    static class CityViewHolder extends RecyclerView.ViewHolder {
        private TextView zipCode;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            zipCode = itemView.findViewById(R.id.zipCode);
        }
    }
}

package com.nomemmurrakh.swipeviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {

    private Context context;
    private ArrayList<Color> colors;

    ColorAdapter(Context context, ArrayList<Color> colors){
        this.context = context;
        this.colors  = colors;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.color_item, parent, false);
        return new ColorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {

        holder.ColorName.setText(colors.get(position).getColorName());
        holder.ColorName.setTextColor(colors.get(position).getColorCode());
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    static class ColorViewHolder extends RecyclerView.ViewHolder{

        private TextView ColorName;

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);

            ColorName = itemView.findViewById(R.id.color_name);
        }
    }
}

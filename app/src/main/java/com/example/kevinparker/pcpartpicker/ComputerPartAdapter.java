package com.example.kevinparker.pcpartpicker;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by doter on 5/5/2017.
 */

public class ComputerPartAdapter extends RecyclerView.Adapter<ComputerPartAdapter.ContactViewHolder> {
    public ArrayList<String[]> stringArrayList = new ArrayList<>();

    public ComputerPartAdapter(String[][] arr) {
        this.stringArrayList = new ArrayList<>(Arrays.asList(arr));
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        String[] curr = stringArrayList.get(position);
        holder.computer_part_img.setImageResource(R.drawable.core_i7);
        /**
         * here is what I want to do. Add a textview for everything in the array
         * and display it...
         */
        for (int i = 0; i < holder.textViews.length; i++) {
            holder.textViews[i].setText(curr[i]);
        }
//        holder.cpu_name.setText(curr[1]);
       /*
        holder.cpu_clockspeed.setText(CON.getEmail());
        holder.cpu_cores.setText(CON.getMobile());
        holder.cpu_tdp.setText(CON.getTdp());
        holder.cpu_price.setText(CON.getPrice());
        */
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder
    {
        ImageView computer_part_img;
//        TextView cpu_name, cpu_clockspeed, cpu_cores, cpu_tdp, cpu_price;
        TextView[] textViews;
        public ContactViewHolder(View view) {
            super(view);
            computer_part_img = (ImageView)view.findViewById(R.id.card_view_img);
           /*
            cpu_name = (TextView)view.findViewById(R.id.cpu_name);
            cpu_clockspeed = (TextView)view.findViewById(R.id.cpu_clockspeed);
            cpu_cores = (TextView)view.findViewById(R.id.cpu_cores);
            cpu_tdp = (TextView)view.findViewById(R.id.cpu_tdp);
            cpu_price = (TextView)view.findViewById(R.id.cpu_price);
            */
           //TODO set the number of textviews programatically if possible
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.card_view_linear_layout);
            textViews = new TextView[5];
            for (int i = 0; i < 5; i++) {
                textViews[i] = new TextView(view.getContext());
                linearLayout.setBackgroundColor(Color.TRANSPARENT);
                linearLayout.addView(textViews[i]);
            }
        }

    }
}

package com.codemine.unofficial.pcpartpicker;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class ComputerPartAdapter extends RecyclerView.Adapter<ComputerPartAdapter.ComputerPartViewHolder> {
    public ArrayList<String[]> stringArrayList = new ArrayList<>();

    public ComputerPartAdapter(String[][] arr) {
        this.stringArrayList = new ArrayList<>(Arrays.asList(arr));
    }

    @Override
    public ComputerPartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new ComputerPartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComputerPartViewHolder holder, int position) {
        String[] curr = stringArrayList.get(position);
        holder.computer_part_img.setImageResource(R.drawable.core_i7);
        Log.i("CURR LENGTH", "" + curr.length);//5

        for (int i = 0; i < curr.length; i++) {
//            Log.i("", curr[i]);
            holder.textViews[i].setText(curr[i]);
        }
//        Log.i("", "END OF OBJ");
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public static class ComputerPartViewHolder extends RecyclerView.ViewHolder {
        ImageView computer_part_img;
//        TextView cpu_name, cpu_clockspeed, cpu_cores, cpu_tdp, cpu_price;
        TextView[] textViews;
        public ComputerPartViewHolder(View view) {
            super(view);
            //TODO change the image programatically
            computer_part_img = (ImageView)view.findViewById(R.id.card_view_img);

            //TODO set the number of textviews programatically
            //Hint try using the curr.length
            //TODO add a textview to the end thats empty, needs some buffer space
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.card_view_linear_layout);
            textViews = new TextView[9];
            for (int i = 0; i < textViews.length; i++) {
                textViews[i] = new TextView(view.getContext());
                linearLayout.setBackgroundColor(Color.TRANSPARENT);
                linearLayout.addView(textViews[i]);
            }
        }
    }
}

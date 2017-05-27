package com.example.kevinparker.pcpartpicker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.kevinparker.pcpartpicker.R.id.cpu_clockspeed;
import static com.example.kevinparker.pcpartpicker.R.id.cpu_cores;
import static com.example.kevinparker.pcpartpicker.R.id.cpu_price;
import static com.example.kevinparker.pcpartpicker.R.id.cpu_tdp;

/**
 * Created by doter on 5/5/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contact> contacts = new ArrayList<>();

    public ContactAdapter(ArrayList<Contact> contacts)
    {
        this.contacts = contacts;
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact CON = contacts.get(position);
        holder.cpu_img.setImageResource(CON.getImage_id());
        holder.cpu_name.setText(CON.getName());
        holder.cpu_clockspeed.setText(CON.getEmail());
        holder.cpu_cores.setText(CON.getMobile());
        holder.cpu_tdp.setText(CON.getTdp());
        holder.cpu_price.setText(CON.getPrice());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static  class ContactViewHolder extends RecyclerView.ViewHolder
    {
        ImageView cpu_img;
        TextView cpu_name, cpu_clockspeed, cpu_cores, cpu_tdp, cpu_price;
    public ContactViewHolder(View view)
    {
        super(view);
        cpu_img = (ImageView)view.findViewById(R.id.cpu_image);
        cpu_name = (TextView)view.findViewById(R.id.cpu_name);
        cpu_clockspeed = (TextView)view.findViewById(R.id.cpu_clockspeed);
        cpu_cores = (TextView)view.findViewById(R.id.cpu_cores);
        cpu_tdp = (TextView)view.findViewById(R.id.cpu_tdp);
        cpu_price = (TextView)view.findViewById(R.id.cpu_price);



    }
    }
}

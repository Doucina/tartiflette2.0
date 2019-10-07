package com.example.tartiflette;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Sunsign> values;

    private OnItemClickListener listener; //je récupère les détails

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView img;
        public View layout;

        public ViewHolder(View v) {

            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            img = v.findViewById(R.id.icon);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)

    public MyAdapter(List<Sunsign> myDataset, OnItemClickListener sunsign_key) {
        values = myDataset;
        listener=sunsign_key;
    }

    @Override

    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    
    // Replace the contents of a view (invoked by the layout manager)

    @Override

    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Sunsign sunsign = values.get(position);
        Picasso.get()
                .load(values.get(position).getUrl())
                .resize(200, 200)
                .into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listener.onItemClick(sunsign);
            }
        });

        holder.txtHeader.setText(sunsign.getSign());
        holder.txtHeader.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listener.onItemClick(sunsign);
            }

        }); //rend l'objet clickable


        holder.txtFooter.setText(sunsign.getBegin() +" - "+ sunsign.getEnd());
        holder.txtFooter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listener.onItemClick(sunsign);
            }

        });

    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override

    public int getItemCount() {
        return values.size();
    }
}
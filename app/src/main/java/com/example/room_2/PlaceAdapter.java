package com.example.room_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PlaceAdapter extends BaseAdapter {
    private Context context;
    private List<Place> places;
    private int layout;

    public PlaceAdapter(Context context, List<Place> places, int layout) {
        this.context = context;
        this.places = places;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Place getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return places.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        TextView tvName = convertView.findViewById(R.id.tvName);
        tvName.setText(places.get(position).getName());

        tvName.setText(places.get(position).getId()+": "+places.get(position).getName());



        return convertView;
    }
}

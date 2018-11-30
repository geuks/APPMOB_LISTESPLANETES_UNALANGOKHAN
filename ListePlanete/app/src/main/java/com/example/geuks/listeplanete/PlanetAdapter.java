package com.example.geuks.listeplanete;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<cPlanet> {
    private ArrayList<cPlanet> planets;
    private int viewRes;
    private Context context;
    private Resources resource;

    public PlanetAdapter(Context context, int textViewResourceId, ArrayList<cPlanet> planets)
    {
        super(context, textViewResourceId, planets);
        this.context = context;
        this.resource = context.getResources();
        this.viewRes = textViewResourceId;
        this.planets = planets;
    }

    static class ViewHolder{
        TextView name;
        TextView text;
        ImageView avatar;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent)
    {
        View view = ConvertView;
        ViewHolder holder;

        if(view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes,parent,false);

            holder = new ViewHolder();

            holder.name = (TextView) view.findViewById(R.id.name);
            holder.text = (TextView) view.findViewById(R.id.text);
            holder.avatar = (ImageView) view.findViewById(R.id.avatar);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        final cPlanet planet = planets.get(position);

        if(planet!=null){
            holder.name.setText(planet.getName());
            holder.text.setText(planet.getText());
            holder.avatar.setImageBitmap(planet.getAvatar());
        }

        return view;
    }

    public int getCount(){
        return planets.size();
    }



}

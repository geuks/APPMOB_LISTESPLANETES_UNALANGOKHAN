package com.example.geuks.listeplanete;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;
//Classe cPlanet qui permet de gérer les différents composants de l'affichage à travers leurs Get et Set
public class cPlanet {
    private String name;
    private String text;
    private Bitmap avatar;
   
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setAvatar(Bitmap avatar){
        this.avatar = avatar;
    }

    public Bitmap getAvatar(){
        return avatar;
    }
}

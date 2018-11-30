package com.example.geuks.listeplanete;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] allName = getResources().getStringArray(R.array.planets);
        String[] allKm = getResources().getStringArray(R.array.km);
        final cPlanet planet = new cPlanet();
        ArrayList<cPlanet> planetsList = new ArrayList<cPlanet>();

        initList(planetsList,planet, allName, allKm);

        PlanetAdapter adapter = new PlanetAdapter(this,R.layout.rowplanet,planetsList);
        final ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
                cPlanet selectedItem = (cPlanet) adapter.getItemAtPosition(i);

                Log.v("STRING_TEST", "Element Selectionné : " + selectedItem.getName());
                Toast.makeText(getApplicationContext(),selectedItem.getName(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initList(ArrayList<cPlanet> planets, cPlanet planet, String[] allName, String[] allKm){
        for(int i = 0; i<allName.length; i++){
            planet = new cPlanet();
            planet.setName(allName[i]);
            planet.setText("Dist moy: " + allKm[i]);
            AssetManager assetManager = getAssets();
            InputStream path = null;
            try {
                path = assetManager.open(allName[i].toLowerCase()+".png");
            } catch (IOException e) {
                e.printStackTrace();
            };
            Bitmap bitmap = BitmapFactory.decodeStream(path);
            planet.setAvatar(bitmap);

            planets.add(planet);
        }
    }
}

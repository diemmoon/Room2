package com.example.room_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PlaceAdapter adapter;
    ListView lv;
    Button btnSave;
    Button btnCancel;
    ImageView btnUpdate;
    ImageView btnDelete;
    EditText pltNhap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "place")
                .allowMainThreadQueries()
                .build();

        PlaceDao placeDao= db.placeDao();
        List<Place> list= placeDao.getAll();
        lv = findViewById(R.id.lv);
        adapter= new PlaceAdapter(this,list, R.layout.item);
        lv.setAdapter(adapter);

        pltNhap= findViewById(R.id.find);
        btnSave= findViewById(R.id.save);
        btnCancel= findViewById(R.id.cancel);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                btnUpdate= findViewById(R.id.update);
                btnDelete= findViewById(R.id.delete);

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        List<Place> l = placeDao.getAll();
                        Place place= placeDao.getById(l.get(position).getId());
                        placeDao.delete(place);
                        lv.setAdapter(new PlaceAdapter(MainActivity.this, placeDao.getAll(), R.layout.item));
                        pltNhap.setText("");
                    }
                });


                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        List<Place> l= placeDao.getAll();
                        Place place= l.get(position);
                        if(pltNhap.getText().toString()!= null){
                            place.setName(pltNhap.getText().toString());
                            placeDao.update(place);
                        }

                        lv.setAdapter(new PlaceAdapter(MainActivity.this, placeDao.getAll(), R.layout.item));
                        pltNhap.setText(place.getName());

                    }
                });


            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= pltNhap.getText().toString();
                Place st= new Place(name);
                placeDao.add(st);
                lv.setAdapter(new PlaceAdapter(MainActivity.this,placeDao.getAll(),  R.layout.item));
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });




    }

}
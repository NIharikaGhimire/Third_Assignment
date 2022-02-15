package com.example.third_lab;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Contact extends AppCompatActivity {
    private RecyclerView rv;

    private String[] names = {"Niharika", "Anushka","Juhi","Pranjal","Simran", "Shweta","Aryan","Samvid"};



    private String[] address = {"Gaurighat", "Pepsicola","Sinamangal","Hattiban","Baneshwor","Patan","Pepsicola","Thimi"};


    private String[] faculty = {"BCA", "BIM","CSIT","BIT", "BBM","BBA","BSW","BCIS"};


    private int[] semester = {1,2,3,4,5,6,7,8};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        rv = findViewById(R.id.rv);
        //define garnu paryo (any)
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CustomAdapter(Contact.this,names,address,faculty,semester));


    }
}



package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MedsPage extends AppCompatActivity {

    private ArrayList<String> items;

    private ArrayAdapter<String> itemsAdapter;


    private EditText med_name, med_number;

    private ListView med_listview;

    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_page);


        med_listview = findViewById(R.id.med_listview);
        med_name = findViewById(R.id.med_name);
        med_number = findViewById(R.id.med_number);
        add = findViewById(R.id.add);

        if (add != null){
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addItems(view);
                }
            });
        } else {
            Toast.makeText(MedsPage.this, "Button not found", Toast.LENGTH_SHORT).show();
        }

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        med_listview.setAdapter(itemsAdapter);
        setUpListViewListener();

    }

    private void setUpListViewListener(){

    }

    private void addItems(View view){
        String name = med_name.getText().toString();
        String frequency = med_number.getText().toString();

        if(!(name.equals(" ")) || frequency.equals(" ")){
            itemsAdapter.add(name);
            med_name.setText(" ");
            itemsAdapter.add(frequency);
            med_number.setText(" ");
        }
        else {
            Toast.makeText(MedsPage.this, "Enter text", Toast.LENGTH_SHORT).show();
        }

    }
}
package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoPage extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;

     private ListView listView;

     private EditText add_item;

     private Button list_button, next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_page);

        listView = findViewById(R.id.listview);
        list_button = findViewById(R.id.list_button);
        add_item = findViewById(R.id.add_item);

        if(list_button != null) {

            list_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addItem(view);

                }
            });

            items = new ArrayList<>();
            itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            listView.setAdapter(itemsAdapter);
            setUpListViewListener();

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextPage();
                }
            });
        } else {
            Toast.makeText(TodoPage.this, "Button not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setUpListViewListener() {
        //listView.setOnItemLongClickListener();
    }

    private void addItem(View view) {
        String item = add_item.getText().toString();


        if(!(item.equals(" "))){
            itemsAdapter.add(item);
            add_item.setText(" ");
        }
        else{
            Toast.makeText(TodoPage.this, "No empty text", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextPage(){
        Intent intent = new Intent(this, MedsPage.class);
        startActivity(intent);
    }
}
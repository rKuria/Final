package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context context;

    ArrayList<UserModel> arrayList;




    @SuppressLint("NotConstructor")
    public void Adapter(Context context, ArrayList<UserModel> arrayList){
        this.context = context;
        this.arrayList=arrayList;
    }


    public View getView(int i, View convertView, ViewGroup parent){

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_admin, null);
            TextView us_names = (TextView) convertView.findViewById(R.id.nameValue);
            TextView us_emails = (TextView) convertView.findViewById(R.id.emailValue);

            UserModel user = arrayList.get(i);
            us_names.setText(user.getName());
            us_emails.setText(user.getEmail());

        }

        return convertView;
    }

    public int getCount(){
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


}

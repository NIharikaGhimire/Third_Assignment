package com.example.third_lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    String[] myNames;
    String[] myAddress;
    String[] myFaculty;
    int[] mySemester;

    public CustomAdapter(Contact m, String[] names,String[] address, String[] faculty,int[] semester) {
        c = m;
        myNames = names;
        myAddress = address;
        myFaculty = faculty;
        mySemester = semester;


    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layoutinflate findviewby id
        View convertView = LayoutInflater.from(c).inflate(R.layout.single_item, null);
        MyViewHolder viewHolder = new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //dataset garne(index ko aadhar ma)
        //output yaha bata
        holder.tv1.setText("Name : "+myNames[position]);
        holder.tv3.setText("Address : "+myAddress[position]);
        holder.tv2.setText("Faculty : "+myFaculty[position]);
        holder.tv.setText("Semester: "+Integer.toString(mySemester[position]));


    }

    @Override
    //kati data dhekauna man cha
    public int getItemCount() {
        return myNames.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv;

        public MyViewHolder(View convertView) {
            super(convertView);
            tv1 = convertView.findViewById(R.id.tv1);
             tv3 = convertView.findViewById(R.id.tv3);
            tv2 = convertView.findViewById(R.id.tv2);
            tv = convertView.findViewById(R.id.tv);



        }
    }

}

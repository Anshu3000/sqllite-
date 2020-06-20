package com.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Contact;
import com.example.sqlite.R;

import java.util.ArrayList;
import java.util.List;


public class Recycleview1 extends RecyclerView.Adapter<Recycleview1.viewhold> {

    private Context con;
    private List<Contact> contactList;

    public Recycleview1(Context con, List<Contact> contactList) {
        this.con = con;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public viewhold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row=LayoutInflater.from(this.con).inflate(R.layout.row1,parent,false);


        return new viewhold(row);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhold holder, int position) {
       Contact c12=contactList.get(position);
       holder.name.setText(c12.getName());
       holder.phone.setText(c12.getPhoneno());
        Log.d("pos1","onBind"+position);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class viewhold extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView phone;

        public viewhold(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.cardTex1);
            phone=itemView.findViewById(R.id.cardTex2);
        }
    }
}

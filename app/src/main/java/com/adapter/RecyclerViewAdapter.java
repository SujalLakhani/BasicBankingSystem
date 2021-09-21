package com.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Persons.Person;
import com.example.basicbankingsystem.MainActivity2;
import com.example.basicbankingsystem.MainActivity3;
import com.example.basicbankingsystem.MainActivity4;
import com.example.basicbankingsystem.MainActivity5;
import com.example.basicbankingsystem.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Person> personList;
    private String email;

    public RecyclerViewAdapter(Context context, ArrayList<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Person person=personList.get(position);
        holder.name.setText(person.getName());
        holder.amount.setText("$ "+String.valueOf(person.getAmount()));

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name,amount;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name=itemView.findViewById(R.id.name);
            amount=itemView.findViewById(R.id.amount);
            icon=itemView.findViewById(R.id.icon);
        }

        @Override
        public void onClick(View v) {
            String a=amount.getText().toString();
            String n=name.getText().toString();
            Intent i;
            if(MainActivity2.check) {
                i=new Intent(context, MainActivity5.class);
            } else {
                i=new Intent(context, MainActivity4.class);
            }


            for(Person person : personList)
            {
                if(person.getAmount()==Integer.parseInt(a.substring(2)) && person.getName().equals(n))
                    email=person.getEmail();

            }
            i.putExtra("amount",a);
            i.putExtra("name",n);
            i.putExtra("email",email);
            context.startActivity(i);
        }
    }
}

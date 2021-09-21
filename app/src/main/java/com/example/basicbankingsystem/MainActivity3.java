package com.example.basicbankingsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.Data.DBHandler;
import com.Persons.Person;
import com.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Person> personArrayList;
    private ArrayAdapter<String> arrayAdapter;
    private DBHandler dbHandler;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        personArrayList=new ArrayList<Person>();
        dbHandler=new DBHandler(MainActivity3.this);
        Intent i=getIntent();
        if(i.getBooleanExtra("transfer",false))
        {
            new AlertDialog.Builder(MainActivity3.this).setIcon(R.drawable.ic_check).setTitle("Trasfered Successfully!!").setMessage("Transaction is completed Successfully!!")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();

        }

        Person person1=new Person();
        person1.setAmount(2000);
        person1.setName("Param Malhotra");
        person1.setEmail("parammalhotra07@gmail.com");
        dbHandler.addPerson(person1);

        Person person2=new Person();
        person2.setAmount(3000);
        person2.setName("Parshwa Jain");
        person2.setEmail("parshwajain71@gmail.com");
        dbHandler.addPerson(person2);

        Person person3=new Person();
        person3.setAmount(1100);
        person3.setName("Ranjit Apte");
        person3.setEmail("ranjitapte14@gmail.com");
        dbHandler.addPerson(person3);

        Person person4=new Person();
        person4.setAmount(2020);
        person4.setName("Parth Chawla");
        person4.setEmail("parthchawla21@gmail.com");
        dbHandler.addPerson(person4);

        Person person5=new Person();
        person5.setAmount(3202);
        person5.setName("Jay Sharma");
        person5.setEmail("jaysharma36@gmail.com");
        dbHandler.addPerson(person5);

        Person person6=new Person();
        person6.setAmount(3100);
        person6.setName("Rahul Patel");
        person6.setEmail("rahulpatel@gmail.com");
        dbHandler.addPerson(person6);

        Person person7=new Person();
        person7.setAmount(2200);
        person7.setName("Parag Kher");
        person7.setEmail("paragkher23@gmail.com");
        dbHandler.addPerson(person7);

        Person person8=new Person();
        person8.setAmount(1020);
        person8.setName("Deep Joshi");
        person8.setEmail("deepjoshi123@gmail.com");
        dbHandler.addPerson(person8);

        Person person9=new Person();
        person9.setAmount(1300);
        person9.setName("Ronak Ahuja");
        person9.setEmail("ronakahuja01@gmail.com");
        dbHandler.addPerson(person9);

        Person person10=new Person();
        person10.setAmount(2600);
        person10.setName("Bhavik Agarwal");
        person10.setEmail("bhavikagarawal12@gmail.com");
        dbHandler.addPerson(person10);

        personArrayList=dbHandler.getAllPersons();
        for(Person person:personArrayList)
        {
            Toast.makeText(MainActivity3.this,person.getName(),Toast.LENGTH_SHORT);
        }
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter=new RecyclerViewAdapter(MainActivity3.this,personArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onBackPressed() {

        if(backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            finishAffinity();
            System.exit(0);
        }
        else {
            backToast = Toast.makeText(getBaseContext(),"Press Back again to Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }

}

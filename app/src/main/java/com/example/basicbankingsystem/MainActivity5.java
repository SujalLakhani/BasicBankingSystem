package com.example.basicbankingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Data.DBHandler;
import com.Perameters.Perameters;
import com.Persons.Person;

public class MainActivity5 extends AppCompatActivity {

    Button send;
    EditText transfer;
    int amount,amount1;
    String email,email1,name,name1,balance,balance1;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        dbHandler=new DBHandler(MainActivity5.this);
        send=findViewById(R.id.send);
        transfer=findViewById(R.id.Dollors);
        transfer.requestFocus();
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkField(MainActivity4.a.getText().toString())) {
                    MainActivity2.check=false;
                    Intent i=getIntent();
                    email=MainActivity4.email.getText().toString();
                    email1=i.getStringExtra("email");
                    name=MainActivity4.n.getText().toString();
                    name1=i.getStringExtra("name");
                    balance=MainActivity4.a.getText().toString();
                    balance1=i.getStringExtra("amount");
                    balance=balance.substring(2);
                    balance1=balance1.substring(2);
                    amount=Integer.parseInt(transfer.getText().toString());
                    amount1=amount;
                    amount=Integer.parseInt(balance)-amount;
                    amount1+=Integer.parseInt(balance1);
                    Person person=new Person(name,amount,email);
                    Person person1=new Person(name1,amount1,email1);
                    dbHandler.updatePerson(person);
                    int affected=dbHandler.updatePerson(person1);
                    //Toast.makeText(MainActivity5.this,"No. of Affected Rows are "+String.valueOf(affected),Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(MainActivity5.this, MainActivity3.class);
                    i1.putExtra("transfer",true);
                    startActivity(i1);
                    finish();
                }
                else {
                    balance=MainActivity4.a.getText().toString();
                    if(!transfer.getText().toString().isEmpty() && (Integer.parseInt(transfer.getText().toString())>Integer.parseInt(balance.substring(2))))
                    {

                        transfer.setError("You can transfer money upto "+balance);
                        transfer.requestFocus();
                    }
                    else {
                        transfer.setError("Enter Valid Amount!!");
                        transfer.requestFocus();
                    }
                }
            }
        });
    }

    public boolean checkField(String balance)
    {
        try {
            Integer.parseInt(transfer.getText().toString());
            if (transfer.getText().toString().isEmpty() || (Integer.parseInt(transfer.getText().toString())>Integer.parseInt(balance.substring(2))))
                return false;

            return true;
        }
        catch (Exception e){
            return false;

        }
    }
}
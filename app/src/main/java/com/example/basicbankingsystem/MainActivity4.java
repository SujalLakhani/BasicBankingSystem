package com.example.basicbankingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    static TextView a;
    static TextView n;
    static TextView email;
    Button transfer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        a=findViewById(R.id.money);
        n=findViewById(R.id.TextView);
        email=findViewById(R.id.email);
        transfer=findViewById(R.id.transfer);
        Intent i=getIntent();
        a.setText(i.getStringExtra("amount"));
        n.setText(i.getStringExtra("name"));
        email.setText(i.getStringExtra("email"));
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.check=true;
                Intent i=new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(i);
                finish();
            }
        });
    }

}
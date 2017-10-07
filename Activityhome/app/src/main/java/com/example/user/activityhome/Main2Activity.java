package com.example.user.activityhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
Button trackveh,accident;
    public EditText mobileno;
    public String phoneno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mobileno= (EditText) findViewById(R.id.trackno) ;
            trackveh =(Button) findViewById(R.id.btn2);
            accident =(Button) findViewById(R.id.btn3);
        trackveh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function_one();
                Intent myIntent = new Intent(v.getContext(), trackvechicle.class);
                startActivity(myIntent);
            }

        });
        accident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), sawanaccident.class);
                startActivity(myIntent);
            }

        });

    }
    public void function_one()
    {
        initialize();
        if(!validate())
        {
            Toast.makeText(this,"Data invalid", Toast.LENGTH_SHORT).show();
        }
        else
        {
            onsignupsuccess();
        }
    }
    public void onsignupsuccess()
    {

    }
    public boolean validate()
    {
        boolean valid=true;
        if(mobileno.length()<10||mobileno.length()>10)
        {
            mobileno.setError("please enter valid mobile number");
            valid=false;
        }
        return valid ;
    }
    public  void initialize() {
        phoneno=mobileno.getText().toString().trim();
    }
    }

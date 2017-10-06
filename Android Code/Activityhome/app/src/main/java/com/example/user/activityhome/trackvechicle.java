package com.example.user.activityhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class trackvechicle extends AppCompatActivity {
    Button trackveh;
    public EditText vehno;
    public String vehicleno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackvechicle);
        vehno= (EditText) findViewById(R.id.trackno) ;
        trackveh =(Button) findViewById(R.id.btn1);
        trackveh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function_one();

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
        if(vehicleno.isEmpty()||vehno.length()>10||vehno.length()<10)
        {
            vehno.setError("please enter valid mobile number");
            valid=false;
        }
        else
        {
            Toast.makeText(this,"Data valid Thank you!", Toast.LENGTH_SHORT).show();
        }
        return valid ;
    }
    public  void initialize() {
        vehicleno=vehno.getText().toString().trim();
    }

}

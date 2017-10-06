package com.example.user.activityhome;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText fname1,lname1,track1a,track2a,vehname1;
    private String firstname,lastname,vehicle_No,track1,track2;
    Button nextstep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager lm= (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
         //Log.i("location",location.toString());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        fname1 = (EditText) findViewById(R.id.fname);
        lname1 = (EditText) findViewById(R.id.Lname);
        vehname1 = (EditText) findViewById(R.id.vehname);
        track1a = (EditText) findViewById(R.id.track1);
        track2a = (EditText) findViewById(R.id.track2);
nextstep =(Button) findViewById(R.id.btn);
        nextstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function_one();
                Intent myIntent = new Intent(v.getContext(), Main2Activity.class);
                startActivity(myIntent);
            }

        });
    }
    public  void function_one()
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
if(firstname.isEmpty()||firstname.length()>12)
{
    fname1.setError("please enter valid name");
    valid=false;
}
    if(lastname.isEmpty()||lastname.length()>12)
    {
        lname1.setError("please enter valid name");
        valid=false;
    }
    if(vehicle_No.isEmpty()||vehicle_No.length()>12)
    {
        vehname1.setError("please enter valid name");
        valid=false;
    }
    if(track1.isEmpty()||track2.length()>12)
    {
        track1a.setError("please enter valid name");
        valid=false;
    }
    if(track2.isEmpty()||track2.length()>12)
    {
        track2a.setError("please enter valid name");
        valid=false;
    }
    return valid;
}
    public  void initialize()
    {
        firstname=fname1.getText().toString().trim();
        lastname=lname1.getText().toString().trim();
        track1=track1a.getText().toString().trim();
        track2=track2a.getText().toString().trim();
        vehicle_No=vehname1.getText().toString().trim();
    }

}

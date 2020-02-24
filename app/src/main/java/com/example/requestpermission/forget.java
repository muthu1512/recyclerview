package com.example.requestpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forget extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ed1=findViewById(R.id.Email);
        ed2=findViewById(R.id.newpass);
        ed3=findViewById(R.id.cpassword);
        bt1=findViewById(R.id.sub);
        final SharedPreferences pref=getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
        final SharedPreferences.Editor ed=pref.edit();
        final String r2=pref.getString("ed2","");//email
        final String r4=pref.getString("ed4","");//pass
        final String r5=pref.getString("ed5","");
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals(r2))
                {
                    String s1=ed2.getText().toString();
                    String s2=ed3.getText().toString();
                    ed.putString("ed4",s1);
                    ed.putString("ed5",s2);
                    ed.apply();
                    Toast.makeText(forget.this, "password changed Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Sign_in.class));
                }
                else{
                    Toast.makeText(forget.this, "email mismatched", Toast.LENGTH_SHORT).show();
                    ed1.setError("email mismatched");
                }
            }
        });
    }
}

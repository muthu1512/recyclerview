package com.example.requestpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button bt1;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ed1=findViewById(R.id.editText3);
        ed2=findViewById(R.id.editText5);
        ed3=findViewById(R.id.editText6);
        ed4=findViewById(R.id.pas);
        ed5=findViewById(R.id.cpass);
        bt1=findViewById(R.id.reg);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
                SharedPreferences.Editor ed=pref.edit();
                String s1=ed1.getText().toString();
                String s2=ed2.getText().toString();
                String s3=ed3.getText().toString();
                String s4=ed4.getText().toString();
                String s5=ed5.getText().toString();

                if (TextUtils.isEmpty(ed1.getText()))
                {
                    Toast.makeText(signup.this, "text is Empty", Toast.LENGTH_SHORT).show();
                    ed1.setError("Empty");
//or type here the code you want
                }
                else if(TextUtils.isEmpty(ed2.getText()))
                {
                    Toast.makeText(signup.this, "text is Empty", Toast.LENGTH_SHORT).show();
                    ed2.setError("Empty");
                }
                else if(TextUtils.isEmpty(ed3.getText()))
                {
                    Toast.makeText(signup.this, "text is Empty", Toast.LENGTH_SHORT).show();
                    ed3.setError("Empty");
                }
                else if(TextUtils.isEmpty(ed4.getText()))
                {
                    Toast.makeText(signup.this, "text is Empty", Toast.LENGTH_SHORT).show();
                    ed4.setError("Empty");
                }
                else if(TextUtils.isEmpty(ed5.getText()))
                {
                    Toast.makeText(signup.this, "text is Empty", Toast.LENGTH_SHORT).show();
                    ed5.setError("Empty");
                }
                else if(!s4.equals(s5))
                {
                    Toast.makeText(signup.this, "Password and confirm password should be same", Toast.LENGTH_SHORT).show();
                    ed5.setError("password & confirm password should be same");
                }
                else {

                    ed.putString("ed1", s1);
                    ed.putString("ed2", s2);
                    ed.putString("ed3", s3);
                    ed.putString("ed4", s4);
                    ed.putString("ed5", s5);
                    ed.apply();
                    Toast.makeText(signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Sign_in.class));
                }

            }
        });
    }
    }

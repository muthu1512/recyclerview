package com.example.requestpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_in extends AppCompatActivity {
    Button bt1,bt2;
    EditText txt1,txt2;
    TextView fg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        txt1=findViewById(R.id.editText);
        txt2=findViewById(R.id.editText2);
        bt1=findViewById(R.id.button);
        fg=findViewById(R.id.textView);
        bt2=findViewById(R.id.button2);

        SharedPreferences pref=getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
        String r1=pref.getString("ed1","");
        String r2=pref.getString("ed2","");
        final String r3=pref.getString("ed3","");
        String r4=pref.getString("ed4","");
        final String r5=pref.getString("ed5","");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((txt1.getText().toString().equals(r3))&&(txt2.getText().toString().equals(r5)))
                {
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(Sign_in.this, "Mismatched username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), signup.class);
                startActivity(i);
            }

        });

        fg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), forget.class);
                startActivity(i);

            }
        });
    }
}

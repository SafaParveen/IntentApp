package com.example.intentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText uname,pwd;
    TextView left,no;
    int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        uname=findViewById(R.id.uname);
        pwd=findViewById(R.id.pwd);
        left= (TextView)findViewById(R.id.left);
        no= (TextView)findViewById(R.id.no);
        //left.setVisibility(View.GONE);

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(uname.getText().toString().equals("admin")&& pwd.getText().toString().equals("admin"))
                {
                    Toast.makeText(getApplicationContext(), "Successful",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MainActivity.this,Profile1.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    counter--;
                    no.setText(Integer.toString(counter));
                    no.setVisibility(View.VISIBLE);

                    if (counter == 0) {
                        finish();
                    }

                }

            }
        });

    }


}
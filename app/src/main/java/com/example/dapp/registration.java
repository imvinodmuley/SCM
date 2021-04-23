package com.example.dapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    private Spinner spinner2;
    private Button btnregister;
    private EditText usernamefield,passwordfield,mobile_nofield,emailfield,namefield;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        passwordfield=(EditText)findViewById(R.id.editTextTextPersonName9);
        mobile_nofield=(EditText)findViewById(R.id.editTextTextPersonName10);
        emailfield=(EditText)findViewById(R.id.editTextTextEmailAddress2);
        namefield=(EditText)findViewById(R.id.editTextTextPersonName7);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnregister = (Button) findViewById(R.id.button3);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
            }
    public void register() {

                String password=passwordfield.getText().toString();
                String mobile_no=mobile_nofield.getText().toString();
                String email=emailfield.getText().toString();
                String name=namefield.getText().toString();
                String stringrole=String.valueOf(spinner2.getSelectedItem());
                String role="0";

                if(stringrole.equals("manufacturer"))
                {
                    role="1";
                }
                if(stringrole.equals("distributor"))
                {
                    role="2";
                }
                if(stringrole.equals("collector"))
                {
                    role="3";
                }
                if(stringrole.equals("customer"))
                {
                    role="4";
                }
//
//
//                String data=username+password+mobile_no+email+name+role;
        Toast.makeText(getApplicationContext(), role, Toast.LENGTH_LONG).show();

                new backgroundprocess(this).execute("2",password,mobile_no,email,name,role);

            }

    private void openMainActivity() {
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
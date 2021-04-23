package com.example.dapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String customermob="";
    Button login_button;
    Button register_button;
    EditText usernamefield,passwordfield;
    TextView treg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernamefield=(EditText)findViewById(R.id.username);
        passwordfield=(EditText)findViewById(R.id.password);

        login_button = (Button) findViewById(R.id.button2);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
//                opendashboardactivity();
            }
        });

//        register_button = (Button) findViewById(R.id.button2);
//        register_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openregisteractivity();
//            }
//        });

    }

    private void login()
    {
        String name=usernamefield.getText().toString();
        customermob=name;
        String pass=passwordfield.getText().toString();
        this.finish();
        //new backgroundprocess(this).execute("1",name,pass);

    }


    private void opendashboardactivity() {


        Intent i =new Intent(this, customer_dashboard.class);
        startActivity(i);


    }

    public  void reg(View view)
    {
        this.finish();
        Intent i =new Intent(this,registration.class);
        startActivity(i);
    }
    


//    private void openregisteractivity(View view) {
//
//    }
}

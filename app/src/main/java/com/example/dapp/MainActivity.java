package com.example.dapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public static String customermob="";
    public static String rewardcount="";
    public static String finecount="";
    public static String rewardcustomermob="";
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
//                login();
                opendashboardactivity();
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

    private boolean isvalidemobilepassword(String mobileno,String pass)
    {
        if(mobileno.equals(""))
        {
            Toast toast = Toast.makeText(this, "Enter mobile no", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        if(pass.equals(""))
        {
            Toast toast = Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        if(mobileno.equals("")&&pass.equals(""))
        {
            Toast toast = Toast.makeText(this, "Enter mobile no and Password", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        return true;
    }

    private void login()
    {
        String name=usernamefield.getText().toString();
        customermob=name;
        String pass=passwordfield.getText().toString();

        if(isvalidemobilepassword(name,pass)) {
            this.finish();
            new backgroundprocess(this).execute("1", name, pass);


        }
        else {
            this.finish();
            this.startActivity(new Intent(this,MainActivity.class));

        }
    }




    private void opendashboardactivity() {
        Intent i =new Intent(this, collector_dashboard.class);
        startActivity(i);
    }

    public  void reg(View view)
    {
        this.finish();
        Intent i =new Intent(this,registration.class);
        startActivity(i);
    }




}

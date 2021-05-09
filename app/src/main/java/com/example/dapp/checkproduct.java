package com.example.dapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class checkproduct extends AppCompatActivity {
    TextView cptv;
    Button cpbtn;
    EditText cpet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkproduct);
        cptv=findViewById(R.id.printstatus);

        cpbtn=findViewById(R.id.searchproduct);
        cpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printproductstatus();
            }
        });

        cpet=findViewById(R.id.productid);
    }

    private void printproductstatus()
    {
        String prodcutid=cpet.getText().toString();
        cptv.setText(prodcutid);
    }
}
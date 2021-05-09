package com.example.dapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class collector_dashboard extends AppCompatActivity {
    CardView cpbtn,crbtn,cfbtn,cnbtn;
    public static String result_display_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collector_dashboard);

        cpbtn=(CardView)findViewById(R.id.collector_products_info);
        cpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_display_product_info();
            }
        });

        crbtn=(CardView)findViewById(R.id.collector_reward);
        crbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_display_reward_product_info();
            }
        });
        cfbtn=(CardView)findViewById(R.id.collector_fine);
        cfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_display_fine_product_info();
            }
        });

        cnbtn=(CardView)findViewById(R.id.collector_checkproduct);
        cnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkproductstatus();
            }
        });



    }
    public void login(View view)
    {
        this.finish();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void collector_scanqr(View view)
    {
        Toast.makeText(getApplicationContext(),"myResult", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, scanqr.class);
        startActivity(intent);

    }

    public void start_displayqr(View view)
    {
        Intent i=new Intent(this,displayqr.class);
        startActivity(i);
    }


    public void start_display_product_info()  {


        try {
            result_display_product=new backgroundprocess(this).execute("4",MainActivity.customermob).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast toast = Toast.makeText(this,result_display_product, Toast.LENGTH_SHORT);
        toast.show();

        Intent i=new Intent(this,display_collector_product.class);
        startActivity(i);
    }


    public void start_display_reward_product_info()  {


        try {
            result_display_product=new backgroundprocess(this).execute("5",MainActivity.customermob).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast toast = Toast.makeText(this,result_display_product, Toast.LENGTH_SHORT);
        toast.show();

        Intent i=new Intent(this,display_collector_product.class);
        startActivity(i);
    }


    public void start_display_fine_product_info()  {


        try {
            result_display_product=new backgroundprocess(this).execute("6",MainActivity.customermob).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast toast = Toast.makeText(this,result_display_product, Toast.LENGTH_SHORT);
        toast.show();

        Intent i=new Intent(this,display_collector_product.class);
        startActivity(i);
    }

    public void checkproductstatus()
    {
        Intent i=new Intent(this,checkproduct.class);
        startActivity(i);
        //new backgroundprocess(this).execute("8","name","pass");
    }

    public String getfinecount()
    {
        String result=MainActivity.finecount;
        return result;
    }

    public String getrewardcount()
    {
        String result=MainActivity.rewardcount;
        return result;
    }

    public void setamount(String amount,String direction)
    {
        new backgroundprocess(this).execute("12", MainActivity.rewardcustomermob,amount,direction);
    }
}
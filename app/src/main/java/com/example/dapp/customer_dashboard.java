package com.example.dapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class customer_dashboard extends AppCompatActivity {
    public static String result_display_product;
    String resulti;
    CardView cpbtn,crbtn,cfbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashboard);

        notification();

        cpbtn=(CardView)findViewById(R.id.products_info);
        cpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_display_product_info();
            }
        });

        crbtn=(CardView)findViewById(R.id.reward);
        crbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_display_reward_product_info();
            }
        });
        cfbtn=(CardView)findViewById(R.id.fine);
        cfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_display_fine_product_info();
            }
        });

    }
    public void login(View view)
    {
        this.finish();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void scanqr(View view)
    {
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

        Intent i=new Intent(this,display_product_info.class);
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

        Intent i=new Intent(this,display_product_info.class);
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

        Intent i=new Intent(this,display_product_info.class);
        startActivity(i);
    }



    public void notification()
    {
        try {
            result_display_product=new backgroundprocess(this).execute("7",MainActivity.customermob).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            JSONArray aj=new JSONArray(result_display_product);

            for(int i=0;i<aj.length();i++)
            {
                JSONObject oj=aj.getJSONObject(i);
                String id=oj.getString("product_id");
                String name=oj.getString("product_name");
                String return_date=oj.getString("return_date");
                String date_diff=oj.getString("date_diff");
                NotificationManager mNotificationManager;

                Context mContext;
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(this.getApplicationContext(), "notify_001");
                Intent ii = new Intent(this.getApplicationContext(), customer_dashboard.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, ii, 0);

                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.setBigContentTitle(date_diff+" days are remaining to return product.");

                mBuilder.setContentIntent(pendingIntent);
                mBuilder.setSmallIcon(R.drawable.ic_stat_name);
                mBuilder.setContentTitle(return_date);
                mBuilder.setContentText("Product id: "+id+" Product name: "+name);
                mBuilder.setPriority(Notification.PRIORITY_MAX);
                mBuilder.setStyle(bigText);

                mNotificationManager =
                        (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    String channelId = "Your_channel_id";
                    NotificationChannel channel = new NotificationChannel(
                            channelId,
                            "Channel human readable title",
                            NotificationManager.IMPORTANCE_HIGH);
                    mNotificationManager.createNotificationChannel(channel);
                    mBuilder.setChannelId(channelId);
                }

                mNotificationManager.notify(i, mBuilder.build());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }





    }
}
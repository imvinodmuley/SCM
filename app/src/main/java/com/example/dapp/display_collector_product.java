package com.example.dapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class display_collector_product extends AppCompatActivity {

    List<Product> productList;
    RecyclerView recyclerView;
    private RecyclerView.Adapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_collector_product);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        try {
            JSONArray aj=new JSONArray(collector_dashboard.result_display_product);

            for(int i=0;i<aj.length();i++)
            {
                JSONObject oj=aj.getJSONObject(i);
                String id=oj.getString("product_id");
                String name=oj.getString("product_name");
                productList.add(new Product(id,name));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ProductAdapter adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        madapter=new ProductAdapter(display_collector_product.this,productList);
        recyclerView.setAdapter(madapter);
    }
}

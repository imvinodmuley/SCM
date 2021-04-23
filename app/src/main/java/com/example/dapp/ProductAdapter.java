package com.example.dapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final Context mCtx;

    private final List<com.example.dapp.Product> productList;

    public ProductAdapter(Context mCtx, List<com.example.dapp.Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        com.example.dapp.Product product = productList.get(position);

        holder.textViewId.setText(product.getId());
        holder.textViewTitle.setText(product.getTitle());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle,textViewId;
        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewId=itemView.findViewById(R.id.textViewId);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);

        }
    }
}
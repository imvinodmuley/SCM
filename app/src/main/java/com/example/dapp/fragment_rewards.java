package com.example.dapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class fragment_rewards extends Fragment {

    EditText amountid;
    Button sendbtn;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        amountid = (EditText) view.findViewById(R.id.rewardamount);
        sendbtn = (Button) view.findViewById(R.id.rewardbtn);
        textView = (TextView) view.findViewById(R.id.rewardcount);



        String rewardcount = new collector_dashboard().getrewardcount();
        textView.setText(rewardcount);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amountid.setText(" ");
                setamount("0");
            }
        });
        return view;
    }
    public void setamount(String direction)
    {
        String amount = amountid.getText().toString();

        Toast toasst = Toast.makeText(getContext(), "amount", Toast.LENGTH_SHORT);
        toasst.show();

        new backgroundprocess(getContext()).execute("12", MainActivity.rewardcustomermob,amount,direction);
    }



}
package com.example.dapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class fragment_fine extends Fragment {
    EditText famountid;
    Button fsendbtn;
    TextView ftextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fine, container, false);

        famountid=(EditText)view.findViewById(R.id.fineamount);
        fsendbtn=(Button)view.findViewById(R.id.finebtn);
        ftextView=(TextView)view.findViewById(R.id.countfine);

        String amount=famountid.getText().toString();

        ftextView.setText(new collector_dashboard().getfinecount());
        fsendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String result=new collector_dashboard().setamount(amount,"1");
//                if(result.equals("done"))
//                {
//                    famountid.setText("");
//                }
//                new collector_dashboard().setamount(amount,"1");
//                famountid.setText(" ");
                setamount("1");
            }
        });
        return view;
    }


    public void setamount(String direction)
    {
        String amount = famountid.getText().toString();

        Toast toasst = Toast.makeText(getContext(), amount, Toast.LENGTH_SHORT);
        toasst.show();

       new backgroundprocess(getContext()).execute("12", MainActivity.rewardcustomermob);
    }



}


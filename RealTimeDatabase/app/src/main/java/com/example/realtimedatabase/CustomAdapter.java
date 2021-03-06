package com.example.realtimedatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<User> {

    private Activity context;
   private List<User>userList;

    public CustomAdapter(Activity context,List<User> userList) {
        super(context,R.layout.sample_layout,userList);
        this.context = context;
        this.userList = userList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);

        User user=userList.get(position);
        TextView t1=view.findViewById(R.id.balanceTextViewId);

        t1.setText("Balance: "+user.getUsedAmount()+" Tk");





        return view;
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddCardActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView fromBank,fromCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Cash");
        setContentView(R.layout.activity_add_card);
        fromBank=(CardView)findViewById(R.id.FromBankCardViewId);
        fromCard=(CardView)findViewById(R.id.FromCardCardViewId);

        fromBank.setOnClickListener(this);
        fromCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        if (view.getId()==R.id.FromBankCardViewId){

            intent=new Intent(getApplicationContext(),AddBankActivity.class);
            startActivity(intent);


        }
       else if (view.getId()==R.id.FromCardCardViewId){
            intent=new Intent(getApplicationContext(),FromCardActivity.class);
            startActivity(intent);


        }


    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FromCardActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView creditCard,debitCard,masterCard,paypalCard,visaCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_card);
        setTitle("Add Cash");

        creditCard=(CardView)findViewById(R.id.creditCardCardViewId);
        debitCard=(CardView)findViewById(R.id.debitCardCardViewId);
        masterCard=(CardView)findViewById(R.id.masterCardCardViewId);
        paypalCard=(CardView)findViewById(R.id.paypalCardCardViewId);
        visaCard=(CardView)findViewById(R.id.visaCardCardViewId);
        creditCard.setOnClickListener(this);
        debitCard.setOnClickListener(this);
        masterCard.setOnClickListener(this);
        paypalCard.setOnClickListener(this);
        visaCard.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.creditCardCardViewId){
            Intent intent=new Intent(getApplicationContext(),CommonActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.debitCardCardViewId){
            Intent intent=new Intent(getApplicationContext(),CommonActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.masterCardCardViewId){
            Intent intent=new Intent(getApplicationContext(),CommonActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.paypalCardCardViewId){
            Intent intent=new Intent(getApplicationContext(),CommonActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.visaCardCardViewId){
            Intent intent=new Intent(getApplicationContext(),CommonActivity.class);
            startActivity(intent);
        }

    }
}

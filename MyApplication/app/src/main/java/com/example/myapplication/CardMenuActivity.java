package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class CardMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView accountDetails,checkBalance,donateCash,mobileRecharge,addCard,payBills,cashOut,transactionHistory;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu);
        mAuth=FirebaseAuth.getInstance();

        setTitle("Home");
        accountDetails=(CardView)findViewById(R.id.accountDetailsCardViewId);
        checkBalance=(CardView)findViewById(R.id.checkBalanceCardViewId);
        donateCash=(CardView)findViewById(R.id.donateCashCardViewId);
        mobileRecharge=(CardView)findViewById(R.id.mobileRechargeCardViewId);
        addCard=(CardView)findViewById(R.id.addCardCardViewId);
        payBills=(CardView)findViewById(R.id.payBillsCardViewId);
        cashOut=(CardView)findViewById(R.id.cashOutCardViewId);
        transactionHistory=(CardView)findViewById(R.id.transactionHistCardViewId);

        accountDetails.setOnClickListener(this);
        checkBalance.setOnClickListener(this);
        donateCash.setOnClickListener(this);
        mobileRecharge.setOnClickListener(this);
        addCard.setOnClickListener(this);
        payBills.setOnClickListener(this);
        cashOut.setOnClickListener(this);
        transactionHistory.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        if (item.getItemId()==R.id.homeId){
            intent=new Intent(getApplicationContext(),CardMenuActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.logoutId){
            FirebaseAuth.getInstance().signOut();
            finish();
            intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.accountDetailsCardViewId)
        {
            Intent intent=new Intent(getApplicationContext(),AccountDetailsActivity.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.checkBalanceCardViewId){

            Intent intent=new Intent(getApplicationContext(),CheckBalanceActivity.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.donateCashCardViewId){

            Intent intent=new Intent(getApplicationContext(),DonateCashActivity.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.mobileRechargeCardViewId){

            Intent intent=new Intent(getApplicationContext(),MobileRechargeActivity.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.addCardCardViewId){

            Intent intent=new Intent(getApplicationContext(),AddCardActivity.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.payBillsCardViewId){

            Intent intent=new Intent(getApplicationContext(),PayBillsActivity.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.cashOutCardViewId){

            Intent intent=new Intent(getApplicationContext(),CashOutActivity.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.transactionHistCardViewId){

            Intent intent=new Intent(getApplicationContext(),TransactionHistoryActivity.class);
            startActivity(intent);

        }




    }

}

package com.example.mynavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
   // private CardView accountActivity,accountDetails,donateCash,transactionHis,addCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=(NavigationView)findViewById(R.id.navigationId) ;
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerId);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Home");

       // accountActivity=(CardView)findViewById(R.id.accountActivityCardViewId);
        //accountDetails=(CardView)findViewById(R.id.accountDetailsCardViewId);
        //donateCash=(CardView)findViewById(R.id.donateCashCardViewId);
        //transactionHis=(CardView)findViewById(R.id.donateCashCardViewId);
        //addCard=(CardView)findViewById(R.id.addcardCardViewId);
       // Handler handler=new Handler();
        //accountActivity.setOnClickListener(handler);
        //accountDetails.setOnClickListener(handler);
        //donateCash.setOnClickListener(handler);
        //transactionHis.setOnClickListener(handler);
        //addCard.setOnClickListener(handler);

    }
   /* class Handler implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.accountActivityCardViewId)
            {
                Intent intent=new Intent(getApplicationContext(),AccountActivity.class);
                startActivity(intent);


            }
            else if (view.getId()==R.id.accountDetailsCardViewId)
            {
                Intent intent=new Intent(getApplicationContext(),AccountDetailsActivity.class);
                startActivity(intent);
            }
            else if (view.getId()==R.id.donateCashCardViewId)
            {
                Intent intent=new Intent(getApplicationContext(),DonateCashActivity.class);
                startActivity(intent);
            }
            else if (view.getId()==R.id.transactionHistoryCardViewId)
            {
                Intent intent=new Intent(getApplicationContext(),TransactionHistoryActivity.class);
                startActivity(intent);
            }
            else if (view.getId()==R.id.addcardCardViewId)
            {
                Intent intent=new Intent(getApplicationContext(),AddCardActivity.class);
                startActivity(intent);
            }

        }

        }
*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        if (menuItem.getItemId()==R.id.homeId){
            intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
            Log.d("Home","I am in Home");
        }
        return true;
    }

}

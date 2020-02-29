package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CashOutActivity extends AppCompatActivity {

    private EditText agentNumber,amount,password;
    private Button cashOutBtn;
    DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_out);
        setTitle("Cash Out");

        databaseReference= FirebaseDatabase.getInstance().getReference();
        agentNumber=(EditText)findViewById(R.id.agentNumberEditTextId);
        amount=(EditText)findViewById(R.id.amountEditTextId);
        password=(EditText)findViewById(R.id.pwdEditTextId);
        cashOutBtn=(Button)findViewById(R.id.cashOutBtnId);

        cashOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });


    }

    private boolean isValidMobileNumber(String mobileNo) {
        int digit = mobileNo.length();
        if( digit != 11 ) return false;
        if( mobileNo.charAt(0) != '0' || mobileNo.charAt(1) != '1' ) return false;

        for(int i = 0; i < mobileNo.length(); i += 1) {
            if( mobileNo.charAt(i) < '0' || mobileNo.charAt(i) > '9' ) return false;
        }
        return true;
    }


    private void saveData() {

        String s1=agentNumber.getText().toString().trim();
        String s2=amount.getText().toString().trim();
        String s3=password.getText().toString().trim();

        if( !isValidMobileNumber(s1) ) {
            Toast.makeText(getApplicationContext(),"Invalid Mobile no",Toast.LENGTH_SHORT).show();
        } else {
            String key=databaseReference.push().getKey();
            CashOut u=new CashOut(s1,s2,s3);
            databaseReference.child(key).setValue(u);
            Toast.makeText(getApplicationContext()," " + "Donation is Successful",Toast.LENGTH_SHORT).show();
        }
        agentNumber.setText("");
        amount.setText("");
        password.setText("");


    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PayBillsActivity extends AppCompatActivity {
    private EditText billNumber,amount,pwd;
    private Button btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bills);
        databaseReference= FirebaseDatabase.getInstance().getReference();


        billNumber=(EditText)findViewById(R.id.mobileNumberEditTextId);
        amount=(EditText)findViewById(R.id.amountEditTextId);
        btn=(Button)findViewById(R.id.okBtnId);
        pwd=(EditText)findViewById(R.id.pwdEditTextId);
        
        btn.setOnClickListener(new View.OnClickListener() {
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


        String s1=billNumber.getText().toString().trim();
        String s2=amount.getText().toString().trim();
        String s3=pwd.getText().toString().trim();

        if( !isValidMobileNumber(s1) ) {
            Toast.makeText(getApplicationContext(),"Invalid Biller No",Toast.LENGTH_SHORT).show();
        } else {
            String key=databaseReference.push().getKey();
            Donate u=new Donate(s1,s2,s3);
            databaseReference.child(key).setValue(u);
            Toast.makeText(getApplicationContext()," " + "Successful",Toast.LENGTH_SHORT).show();
        }
        billNumber.setText("");
        amount.setText("");
        pwd.setText("");

    }
}

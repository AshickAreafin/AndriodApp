package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonateCashActivity extends AppCompatActivity {

    private EditText cellNumber,amount,password;
    private Button saveBtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_cash);
        setTitle("Donate Cash");

        databaseReference= FirebaseDatabase.getInstance().getReference();
        cellNumber=(EditText)findViewById(R.id.mobileNumberEditTextId);
        amount=(EditText)findViewById(R.id.amountEditTextId);
        password=(EditText)findViewById(R.id.pwdEditTextId);
        saveBtn=(Button)findViewById(R.id.okBtnId);

        saveBtn.setOnClickListener(new View.OnClickListener() {
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


        String s1=cellNumber.getText().toString().trim();
        String s2=amount.getText().toString().trim();
        String s3=password.getText().toString().trim();

        if( !isValidMobileNumber(s1) ) {
            Toast.makeText(getApplicationContext(),"Invalid Mobile no",Toast.LENGTH_SHORT).show();
        } else {
            String key=databaseReference.push().getKey();
            Donate u=new Donate(s1,s2,s3);
            databaseReference.child(key).setValue(u);
            Toast.makeText(getApplicationContext()," " + "Donation is Successful",Toast.LENGTH_SHORT).show();
        }
        cellNumber.setText("");
        amount.setText("");
        password.setText("");


    }
}

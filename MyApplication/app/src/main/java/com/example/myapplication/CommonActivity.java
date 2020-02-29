package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CommonActivity extends AppCompatActivity {
    private EditText amount,cardNumber,cardholderName,expiryDate,cvv;
    private Button addButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        setTitle("Add Cash");
        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        amount=(EditText)findViewById(R.id.amountEditTextId);
        cardNumber=(EditText)findViewById(R.id.cardNumberEditTextId);
        cardholderName=(EditText)findViewById(R.id.cardholderNameEditTextId);
        expiryDate=(EditText)findViewById(R.id.expiryDateEditTextId);
        cvv=(EditText)findViewById(R.id.cvvEditTextId);
        addButton=(Button) findViewById(R.id.addBtnId);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDate();
            }

            private void saveDate() {

                String amountCash=amount.getText().toString().trim();
                String cardNum=cardNumber.getText().toString().trim();
                String HolderName=cardholderName.getText().toString().trim();
                String expDate=expiryDate.getText().toString().trim();
                String cardVerificationValue=cvv.getText().toString().trim();

                String key=databaseReference.push().getKey();
               // int reposit = Integer.parseInt(amountCash);


                User user=new User(amountCash,cardNum,HolderName,expDate,cardVerificationValue);
                databaseReference.child(key).setValue(user);
                Toast.makeText(getApplicationContext(),"Cash is Added",Toast.LENGTH_SHORT).show();

                amount.setText("");
                cardNumber.setText("");
                cardholderName.setText("");
                expiryDate.setText("");
                cvv.setText("");





            }
        });

    }
}

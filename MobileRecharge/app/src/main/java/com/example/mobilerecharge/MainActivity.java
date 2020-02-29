package com.example.mobilerecharge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class MainActivity extends AppCompatActivity {

    String[] simNames;
    String[] typesOfSim;
    private Spinner simCard,style;
    private EditText mobileNumber,amount;
    private Button btn;
   // private TextView showDetails;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        simNames=getResources().getStringArray(R.array.sim_Name);
        typesOfSim=getResources().getStringArray(R.array.types_sim);
       simCard=(Spinner)findViewById(R.id.mobileOperatorId);
        style=(Spinner)findViewById(R.id.styleId);
        mobileNumber=(EditText)findViewById(R.id.mobileNumberEditTextId);
        amount=(EditText)findViewById(R.id.amountEditTextId);
        btn=(Button)findViewById(R.id.okBtnId);
       // showDetails=(TextView)findViewById(R.id.showDetailsId);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.sample_view,R.id.textViewId,simNames);
        simCard.setAdapter(adapter);
        ArrayAdapter<String> Adapter=new ArrayAdapter<String>(this,R.layout.simple_type,R.id.typeTextViewId,typesOfSim);
        style.setAdapter(Adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();

            }
        });

    }

    private boolean isValidMobileNumber(String brand, String mobileNo) {
        int digit = mobileNo.length();
        if( digit != 11 ) return false;
        if( mobileNo.charAt(0) != '0' || mobileNo.charAt(1) != '1' ) return false;
        if( brand.charAt(0) == 'B' && !(mobileNo.charAt(2) == '9' || mobileNo.charAt(2) == '4') )
            return  false;
        if( brand.charAt(0) == 'G' && !(mobileNo.charAt(2) == '7' || mobileNo.charAt(2) == '3') )
            return  false;

        if( brand.charAt(0) == 'R' && !(mobileNo.charAt(2) == '8') )
            return  false;
        if( brand.charAt(0) == 'A' && !(mobileNo.charAt(2) == '6') )
            return  false;
        if( brand.charAt(0) == 'T' && !(mobileNo.charAt(2) == '5') )
            return  false;

        for(int i = 0; i < mobileNo.length(); i += 1) {
            if( mobileNo.charAt(i) < '0' || mobileNo.charAt(i) > '9' ) return false;
        }
        return true;
    }

    private void saveData() {
        String s1=simCard.getSelectedItem().toString().trim();
        String s2=style.getSelectedItem().toString().trim();
        String s3=mobileNumber.getText().toString().trim();
        String s4=amount.getText().toString().trim();



        if( !isValidMobileNumber(s1, s3) ) {
            Toast.makeText(getApplicationContext(),"Invalid Mobile no",Toast.LENGTH_SHORT).show();
        } else {
            String key=databaseReference.push().getKey();
            user u=new user(s1,s2,s3,s4);
            databaseReference.child(key).setValue(u);
            Toast.makeText(getApplicationContext()," " + "Mobile Recharge is Successful",Toast.LENGTH_SHORT).show();
        }

       // simCard.setText(s1);
      //  style.setAdapter("s2");
        mobileNumber.setText("");
        amount.setText("");


    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AddBankActivity extends AppCompatActivity {
    private TextView barcBank,cityBank,dhakaBank,dutchBanglaBank,bankAsia,mutualTrustBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank);
        setTitle("Add Cash");
        barcBank=(TextView)findViewById(R.id.bracBankTextViewId);
        cityBank=(TextView)findViewById(R.id.cityBankTextViewId);
        dhakaBank=(TextView)findViewById(R.id.dhakaBankTextViewId);
        dutchBanglaBank=(TextView)findViewById(R.id.dutchBanglaBankTextViewId);
        bankAsia=(TextView)findViewById(R.id.bankAsiaTextViewId);
        mutualTrustBank=(TextView)findViewById(R.id.mutualTrustBankTextViewId);

        barcBank.setMovementMethod(LinkMovementMethod.getInstance());
        cityBank.setMovementMethod(LinkMovementMethod.getInstance());
        dhakaBank.setMovementMethod(LinkMovementMethod.getInstance());
        dutchBanglaBank.setMovementMethod(LinkMovementMethod.getInstance());
        bankAsia.setMovementMethod(LinkMovementMethod.getInstance());
        mutualTrustBank.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

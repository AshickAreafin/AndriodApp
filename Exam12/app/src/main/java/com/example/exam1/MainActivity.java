package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inp,out;
    Button bprime,bfacto;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inp= findViewById(R.id.input);
        out=findViewById(R.id.result);
        bprime=findViewById(R.id.prime);
        bfacto=findViewById(R.id.factorial);

        bprime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inp.getText().toString().equals("")) {
                    n = Integer.parseInt(inp.getText().toString());
                }

                if (n == 1 || n == 0)
                    Toast.makeText(getApplicationContext(), "This is not a prime", Toast.LENGTH_LONG).show();

                else {
                    boolean pr = true;
                    for (int i = 2; i * i <= n; i++) {
                        if (n % i == 0) {
                            pr = false;
                            break;
                        }
                    }
                    if (pr == true)
                        Toast.makeText(getApplicationContext(), "This is a prime", Toast.LENGTH_LONG).show();

                    else
                        Toast.makeText(getApplicationContext(), "This is not a prime", Toast.LENGTH_LONG).show();
                }
            }
        });

        bfacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inp.getText().toString().equals("")) {
                    n = Integer.parseInt(inp.getText().toString());
                }
                int x=1;
                for(int i=1;i<=n;i++)
                {
                    x*=i;
                }
                String X= String.valueOf(x);
                //  if(n==0) X="0";
                out.setText(X);

            }
        });


    }

}

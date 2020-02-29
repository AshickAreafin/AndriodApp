package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText signupEmail,signuppwd;
    private Button signupbtn;
    private TextView logintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setTitle("SignUp");

        mAuth = FirebaseAuth.getInstance();

        signupEmail=(EditText)findViewById(R.id.signupEmailId);
        signuppwd=(EditText)findViewById(R.id.signupPasswordId);
        signupbtn=(Button)findViewById(R.id.signupbtnId);
        logintext=(TextView)findViewById(R.id.loginTextId);
        signupbtn.setOnClickListener(this);
        logintext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.signupbtnId:

                userregister();

                break;

            case R.id.loginTextId:

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void userregister() {

        String email= signupEmail.getText().toString().trim();
        String pwd= signuppwd.getText().toString().trim();

        if(email.isEmpty())
        {
            signupEmail.setError("Enter an email address");
            signupEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signupEmail.setError("Enter a valid email address");
            signupEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(pwd.isEmpty())
        {
            signuppwd.setError("Enter a password");
            signuppwd.requestFocus();
            return;
        }
        if(pwd.length()<6){

            signuppwd.setError("Minimum Length of Password should be 6");
            signuppwd.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Register Is Successful",Toast.LENGTH_LONG).show();

                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){

                        Toast.makeText(getApplicationContext(),"User is Already Register ",Toast.LENGTH_LONG).show();

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Error:"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}

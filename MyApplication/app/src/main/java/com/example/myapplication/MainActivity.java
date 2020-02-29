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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText loginEmail,loginPwd;
    private Button loginBtn;
    private TextView signupText;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("LogIn");
        mAuth = FirebaseAuth.getInstance();

        loginEmail=(EditText)findViewById(R.id.emailTextId);
        loginPwd=(EditText)findViewById(R.id.passwordTextId);
        loginBtn=(Button)findViewById(R.id.loginbtnId);
        signupText=(TextView)findViewById(R.id.signupTextId);

        loginBtn.setOnClickListener(this);
        signupText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginbtnId:

                userlogin();

                break;

            case R.id.signupTextId:

                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void userlogin() {
        String email= loginEmail.getText().toString().trim();
        String pwd= loginPwd.getText().toString().trim();

        if(email.isEmpty())
        {
            loginEmail.setError("Enter an email address");
            loginEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            loginEmail.setError("Enter a valid email address");
            loginEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(pwd.isEmpty())
        {
            loginPwd.setError("Enter a password");
            loginPwd.requestFocus();
            return;
        }
        if(pwd.length()<6){

            loginPwd.setError("Minimum Length of Password should be 6");
            loginPwd.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(getApplicationContext(),CardMenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"LogIn is UnSuccessful",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}

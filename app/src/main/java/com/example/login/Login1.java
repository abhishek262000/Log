package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;

public class Login1 extends AppCompatActivity {
    EditText email,pass;
    TextView gotoreg,forgotpass;
    Button login;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mState;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.emaillogin);
        pass = (EditText) findViewById(R.id.passwordlogin);
        login = (Button) findViewById(R.id.buttonlogin);
        gotoreg = (TextView) findViewById(R.id.returntowel);
        forgotpass = (TextView) findViewById(R.id.forgotpass);
        progressDialog = new ProgressDialog(this);
        mState =new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mUser=mAuth.getCurrentUser();
                if(mUser!= null){
                    Toast.makeText(Login1.this, "You are logged in!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login1.this, Secondm.class));
                }
                else
                {
                    Toast.makeText(Login1.this, "Please log in!", Toast.LENGTH_SHORT).show();
                }
            }
        };
       
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { String getemail = email.getText().toString();
                String getpass = pass.getText().toString();
                if (getemail.isEmpty()) {
                    email.setError("PLEASE ENTER YOUR EMAIL ID");
                    email.requestFocus();
                } else if (getpass.isEmpty()) {
                    pass.setError("PLEASE ENTER PASSWORD");
                    pass.requestFocus();
                } else if (getemail.isEmpty() && getpass.isEmpty())

                    Toast.makeText(Login1.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                else if (!getemail.isEmpty() && !getpass.isEmpty()) {
                    progressDialog.setMessage("Authenticating!!");
                    progressDialog.show();
                    mAuth.signInWithEmailAndPassword(getemail,getpass).addOnCompleteListener(Login1.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(Login1.this, "SignUp Unsuccessful!", Toast.LENGTH_SHORT).show();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(Login1.this, "SignUp Successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login1.this, Secondm.class));

                            }
                        }
                    });

                }
              else {
                    Toast.makeText(Login1.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                }

            }
                

        });
        gotoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login1.this,MainActivity.class));
            }
        });
   }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mState);
    }
}
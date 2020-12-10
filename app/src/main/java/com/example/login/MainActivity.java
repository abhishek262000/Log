package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email,pass;
    TextView gotologin;
    Button register;
    private FirebaseAuth mAuth;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.Emailet);
        pass = (EditText) findViewById(R.id.Passwordl);
        register = (Button) findViewById(R.id.buttonloginl);
        gotologin = (TextView) findViewById(R.id.returntolog);
        pd = new ProgressDialog(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getemail = email.getText().toString();
                String getpass = pass.getText().toString();
                if (getemail.isEmpty()) {
                    email.setError("PLEASE ENTER YOUR EMAIL ID");
                    email.requestFocus();
                } else if (getpass.isEmpty()) {
                    pass.setError("PLEASE ENTER PASSWORD");
                    pass.requestFocus();
                } else if (getemail.isEmpty() && getpass.isEmpty())

                    Toast.makeText(MainActivity.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                else if (!getemail.isEmpty() && !getpass.isEmpty()) {
                    pd.setMessage("Registering...");
                    pd.show();
                    mAuth.createUserWithEmailAndPassword(getemail, getpass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "SignUp Unsuccessful!", Toast.LENGTH_SHORT).show();
                                pd.dismiss();
                            } else {
                                pd.dismiss();
                                Toast.makeText(MainActivity.this, "SignUp Successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, Secondm.class));
                            }
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                }

            }
       });
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login1.class));
            }
        });

    }
}
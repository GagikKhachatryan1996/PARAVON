package com.aca.paravon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button registration;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        setTitle("");


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.log_in);
        registration = findViewById(R.id.registration);

        mAuth = FirebaseAuth.getInstance();

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=username.getText().toString();
                String passwordd=password.getText().toString();

                if (email.isEmpty()) {

                    username.setError("");
                } else if (passwordd.isEmpty()) {

                    password.setError("");
                } else if (email.isEmpty() && passwordd.isEmpty()) {

                    Toast.makeText(RegistrActivity.this, "Մուտքագրեք ձեր տվյալները", Toast.LENGTH_SHORT).show();
                } else if (!email.isEmpty() && !passwordd.isEmpty()) {


                    mAuth.createUserWithEmailAndPassword(email, passwordd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(RegistrActivity.this, "Registartion succes", Toast.LENGTH_SHORT).show();


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(RegistrActivity.this, "Registartion failure", Toast.LENGTH_SHORT).show();


                        }
                    });


                }


            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = username.getText().toString();
                String passwordd = password.getText().toString();

                if (email.isEmpty()) {

                    username.setError("");
                } else if (passwordd.isEmpty()) {

                    password.setError("");
                } else if (email.isEmpty() && passwordd.isEmpty()) {

                    Toast.makeText(RegistrActivity.this, "Մուտքագրեք ձեր տվյալները", Toast.LENGTH_SHORT).show();
                } else if (!email.isEmpty() && !passwordd.isEmpty()) {

                    mAuth.signInWithEmailAndPassword(email, passwordd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(RegistrActivity.this, "Login succes", Toast.LENGTH_SHORT).show();

                          Intent intent = new Intent(RegistrActivity.this, MenuActivity.class);
                          startActivity(intent);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(RegistrActivity.this, "Login failure", Toast.LENGTH_SHORT).show();


                        }
                    });


                }
            }
        });
}



    }








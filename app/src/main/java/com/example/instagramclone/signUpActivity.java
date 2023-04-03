package com.example.instagramclone;


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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class signUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText fullname, email , password;
        TextView alreadyHaveAnAccount, errorTVObj;
        Button signupBtn;
        FirebaseAuth firebaseAuth;
        FirebaseFirestore firestore;


        fullname = findViewById(R.id.nameId);
        email = findViewById(R.id.signupEmailID);
        password = findViewById(R.id.passwordId);
        signupBtn = findViewById(R.id.registerId);
        alreadyHaveAnAccount = findViewById(R.id.alreadyHaveAccountID);
        errorTVObj = findViewById(R.id.errorsTVID);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();


        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signUpActivity.this,signInActivity.class));
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Map<Object, String> usersLoginDetails = new HashMap<>();
                                    usersLoginDetails.put("FullName", fullname.getText().toString());
                                    usersLoginDetails.put("UserLoginEmail", email.getText().toString());
                                    usersLoginDetails.put("loginPassword", password.getText().toString());

                                    firestore.collection("usersLoginDetails")
                                            .add(usersLoginDetails)
                                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                                    if (task.isSuccessful()) {
                                                        Intent mainIntent = new Intent(signUpActivity.this, MainActivity.class);
                                                        startActivity(mainIntent);
                                                        finish();
                                                    } else {
                                                        String err = task.getException().getMessage();
                                                        Toast.makeText(signUpActivity.this, err, Toast.LENGTH_SHORT).show();
                                                        errorTVObj.setText(err);
                                                    }
                                                }
                                            });
                                } else {
                                    String err = task.getException().getMessage();
                                    Toast.makeText(signUpActivity.this, err, Toast.LENGTH_SHORT).show();
                                    errorTVObj.setText(err);
                                }
                            }
                        });
            }
        });
    }
}


package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class RegisterwithMailActivity2 extends AppCompatActivity {
        EditText email,pass,pass2;
        ImageView register,mobile,signintext;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    private static final String TAG = "hello";
    private  static int RC_SIGN_IN =1000;
    private static final String EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerwith_mail2);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(RegisterwithMailActivity2.this);
        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);
        pass2 = findViewById(R.id.editTextTextPassword2);

        mobile=findViewById(R.id.imageView51);
        register=findViewById(R.id.imageView41);
        signintext=findViewById(R.id.imageView52);
        signintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterwithMailActivity2.this,LoginwithEmailActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((email.getText().toString().length()<5)){
                    Toast.makeText(RegisterwithMailActivity2.this, "Please enter Correct Email: ",Toast.LENGTH_LONG).show();
                    return;
                }
                if((pass.getText().toString().isEmpty())){
                    Toast.makeText(RegisterwithMailActivity2.this, "Please enter Password: ",Toast.LENGTH_LONG).show();
                    return;
                }
                if((pass2.getText().toString().isEmpty())){
                    Toast.makeText(RegisterwithMailActivity2.this, "Please RE-enter Password: ",Toast.LENGTH_LONG).show();
                    return;
                }
                String pa1= pass.getText().toString().trim();
                String pa2 =pass2.getText().toString().trim();
                if((pass.getText().toString().length()<8)){
                    Toast.makeText(RegisterwithMailActivity2.this, "Password Must be greater than 8 character: ",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!pa1.equals(pa2)){
                    Toast.makeText(RegisterwithMailActivity2.this, "Password Does not Match: ",Toast.LENGTH_LONG).show();
                    return;
                }
                progressDialog.setTitle("Registeration");
                progressDialog.setTitle("Please wait, unitl user Account Created");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                LayoutInflater inflater = getLayoutInflater();
                String email2=email.getText().toString().trim();
                String password = pass.getText().toString().trim();
                Toast.makeText(RegisterwithMailActivity2.this, email2,Toast.LENGTH_LONG).show();


                firebaseAuth.createUserWithEmailAndPassword(email2,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Toast.makeText(RegisterwithMailActivity2.this, "User Created",Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(RegisterwithMailActivity2.this,CompleteProfileActivity.class);
                            startActivity(intent);
                            finish();

                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(RegisterwithMailActivity2.this, task.getException().toString(),Toast.LENGTH_LONG).show();



                        }
                    }
                });

            }
        });

        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterwithMailActivity2.this,RegisterWithMobileActivity.class);
                startActivity(intent);
            }
        });





    }






    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

    }

}
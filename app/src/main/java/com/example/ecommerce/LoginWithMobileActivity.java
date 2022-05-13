package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import static android.content.ContentValues.TAG;

public class LoginWithMobileActivity extends AppCompatActivity {
    EditText mobile;
    ImageView send;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_mobile);
        mobile=findViewById(R.id.editTextPhone2);
        send=findViewById(R.id.imageView63);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(LoginWithMobileActivity.this);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mobile.getText().toString().trim().isEmpty()){
                    if((mobile.getText().toString().trim()).length() == 11){
                        progressDialog.setTitle("OTP Sending");
                        progressDialog.setTitle("Please wait, unitl OTP Send");
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.show();


                        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(PhoneAuthCredential credential) {
                                progressDialog.dismiss();
                                Log.d(TAG, "onVerificationCompleted:" + credential);

                            }

                            @Override
                            public void onVerificationFailed(FirebaseException e) {
                                progressDialog.dismiss();
                                Log.w(TAG, "onVerificationFailed", e);
                                Toast.makeText(LoginWithMobileActivity.this,"onVerificationFailed:  "+e.getMessage(),Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                progressDialog.dismiss();
                                Intent intent = new Intent(getApplicationContext(),LoginOTPActivity.class);
                                intent.putExtra("mobile",mobile.getText().toString());
                                intent.putExtra("backotp",verificationId);
                                startActivity(intent);
                                // Log.d(TAG, "onCodeSent:" + verificationId);


                            }
                        };
                        PhoneAuthOptions options =
                                PhoneAuthOptions.newBuilder(firebaseAuth)
                                        .setPhoneNumber("+88"+mobile.getText().toString())       // Phone number to verify
                                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                        .setActivity(LoginWithMobileActivity.this)                 // Activity (for callback binding)
                                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                        .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);

                    }else
                    {

                        Toast.makeText(LoginWithMobileActivity.this,"Please Enter Correct Mobile Number",Toast.LENGTH_LONG).show();
                    }
                }else {

                    Toast.makeText(LoginWithMobileActivity.this,"Please Enter Mobile Number",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
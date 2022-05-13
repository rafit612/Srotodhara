package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

public class LoginOTPActivity extends AppCompatActivity {
    EditText otp;
    ImageView submit;
    TextView number,countDown;
    String backedotp;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    LinearLayout resent;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otpactivity);

        otp=findViewById(R.id.editTextNumber2);
        submit=findViewById(R.id.imageView65);
        number=findViewById(R.id.textView3a);
        resent=findViewById(R.id.linearLayout2ab);
        resent.setVisibility(View.GONE);
        countDown=findViewById(R.id.textViewcount2);
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {

                // Used for formatting digit to be in 2 digits only

                NumberFormat f = new DecimalFormat("00");

                long hour = (millisUntilFinished / 3600000) % 24;

                long min = (millisUntilFinished / 60000) % 60;

                long sec = (millisUntilFinished / 1000) % 60;

                countDown.setText("Try Resent After "+f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));

            }

            // When the task is over it will print 00:00:00 there



            public void onFinish() {

                countDown.setText("Now You Can Resend");

                resent.setVisibility(View.VISIBLE);
            }

        }.start();
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(LoginOTPActivity.this);
        backedotp=getIntent().getStringExtra("backotp");
        number.setText(String.format("+88-%s",getIntent().getStringExtra("mobile")));
        resent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resent.setVisibility(View.GONE);
                new CountDownTimer(60000, 1000) {

                    public void onTick(long millisUntilFinished) {

                        // Used for formatting digit to be in 2 digits only

                        NumberFormat f = new DecimalFormat("00");

                        long hour = (millisUntilFinished / 3600000) % 24;

                        long min = (millisUntilFinished / 60000) % 60;

                        long sec = (millisUntilFinished / 1000) % 60;

                        countDown.setText("Try Resent After "+ f.format(min) + ":" + f.format(sec));

                    }

                    // When the task is over it will print 00:00:00 there



                    public void onFinish() {

                        countDown.setText("Now You Can Resend");

                        resent.setVisibility(View.VISIBLE);
                    }

                }.start();
                mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential credential) {

                        Log.d(ContentValues.TAG, "onVerificationCompleted:" + credential);

                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {

                        Log.w(ContentValues.TAG, "onVerificationFailed", e);
                        Toast.makeText(LoginOTPActivity.this,"onVerificationFailed:  "+e.getMessage(),Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCodeSent(@NonNull String verificationId,
                                           @NonNull PhoneAuthProvider.ForceResendingToken token) {
                        backedotp=verificationId;
                        Toast.makeText(LoginOTPActivity.this,"OTP send Successfully",Toast.LENGTH_LONG).show();

                        // Log.d(TAG, "onCodeSent:" + verificationId);


                    }
                };
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(firebaseAuth)
                                .setPhoneNumber("+88"+getIntent().getStringExtra("mobile"))       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(LoginOTPActivity.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setTitle("Signing");
                progressDialog.setTitle("Please wait");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                if(otp.getText().toString().isEmpty()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginOTPActivity.this,"Please input OTP",Toast.LENGTH_LONG).show();

                }
                else if(otp.getText().toString().length()<6){
                    progressDialog.dismiss();
                    Toast.makeText(LoginOTPActivity.this,"Please input OTP correct",Toast.LENGTH_LONG).show();

                }
                else if(backedotp==null){
                    progressDialog.dismiss();
                    Toast.makeText(LoginOTPActivity.this,"Please check internet for OTP",Toast.LENGTH_LONG).show();

                }
                else {
                    String code =otp.getText().toString();
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(backedotp ,code);
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressDialog.dismiss();
                            Toast.makeText(LoginOTPActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                            FirebaseUser user = task.getResult().getUser();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("mobil1e",getIntent().getStringExtra("mobile"));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);


                            // Update UI
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(LoginOTPActivity.this,"Registration Failed",Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}
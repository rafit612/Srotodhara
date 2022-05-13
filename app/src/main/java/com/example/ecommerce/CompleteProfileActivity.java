package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CompleteProfileActivity extends AppCompatActivity {
EditText name,mobile;
ImageView submit;
ImageView finish;
String mobiles,names;
    FirebaseFirestore fstore;
    String userID;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        mobiles=getIntent().getStringExtra("mobile1");

        name=findViewById(R.id.editTextTextPersonName);
        name.setText(mobiles);
        mobile=findViewById(R.id.editTextPhone3);
        if(mobile==null){
            mobile.setVisibility(View.VISIBLE);
        }
        else {
            mobile.setVisibility(View.GONE);
        }
        finish=findViewById(R.id.imageView66);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CompleteProfileActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCCustomerInfoInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization;
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType;
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz;
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nullable;
import static android.content.ContentValues.TAG;

public class DeliveryDetailActivity extends AppCompatActivity implements SSLCTransactionResponseListener, View.OnClickListener {
    String t_price,quantity,pid,title,price,brand,roadN0,blockNO,areaNO,other,sec_contact,dist,add2,currentDateAndTime,currentDateAndTime1,currentDateAndTime2;
    EditText address,district,sec_mob,road,block,area,ps;
    RadioButton cash;
    RadioGroup deliveryRadioGroup;
    Button finish;
    TextView name,quan,tot;
    ImageView pro_image;
    StorageReference storageReference;
    public FirebaseFirestore fstore;
    FirebaseAuth firebaseAuth;
    String userID;
    ProgressDialog progressDialog;
    int selectedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_detail);
        deliveryRadioGroup =findViewById(R.id.deliveryOption);
       selectedId = deliveryRadioGroup.getCheckedRadioButtonId();
        firebaseAuth = FirebaseAuth.getInstance();
        userID = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();
        progressDialog = new ProgressDialog(DeliveryDetailActivity.this);
        fstore= FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        cash =findViewById(selectedId);
        pid=getIntent().getStringExtra("pid");
        title=getIntent().getStringExtra("title");
        brand=getIntent().getStringExtra("brand");
        //capacity=getIntent().getStringExtra("capacity");
        quantity=getIntent().getStringExtra("Quantity");
        price=getIntent().getStringExtra("price");
        t_price=getIntent().getStringExtra("total_price");
        address= findViewById(R.id.editTextTextPersonName2);
        district=findViewById(R.id.editTextTextPersonName3);
        sec_mob= findViewById(R.id.editTextPhone4);
        road = findViewById(R.id.editTextNumber3);
        block = findViewById(R.id.editTextTextPersonName4);
        area = findViewById(R.id.editTextTextPersonName5);
        ps = findViewById(R.id.editTextTextPersonName7);

        name=findViewById(R.id.textView18);
        quan = findViewById(R.id.textView23);
        tot =findViewById(R.id.textView19);
        finish = findViewById(R.id.button3);
        pro_image = findViewById(R.id.imageView68);

        name.setText(title);
        quan.setText(quantity);
        tot.setText(t_price);
        StorageReference cosmopic = storageReference.child("all_product/"+pid+".jpg");
        cosmopic.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(pro_image);
                //Picasso.get().load(uri).into(edit_pic);
                DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
                String currentDateAndTime = df.format(new Date())+userID;


            }
        });
        finish.setOnClickListener(this);

    }

    @Override
    public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {
        progressDialog.setTitle("Wait");
        progressDialog.setTitle("Working");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        final DocumentReference documentReference1 = fstore.collection("Processing").document(currentDateAndTime);
        documentReference1.addSnapshotListener(DeliveryDetailActivity.this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                Map<String, Object> user = new HashMap<>();
                user.put("Name", "Unknown");
                user.put("Mobile", sec_contact);
                user.put("Road", roadN0);
                user.put("Uploader_ID", userID);
                user.put("District", dist);
                user.put("Address", add2);
                user.put("PID", pid);
                user.put("Block", blockNO);
                user.put("Area", areaNO);
                user.put("Others", other);
                user.put("Quantity", quantity);
                user.put("Price", price);
                user.put("Total_Price", t_price);
                user.put("Title", title);
                user.put("Brand", brand);
                user.put("Paid", "Not");
                user.put("Payment_Type", "SSL");
                user.put("Status", "Procesing");
                user.put("SIN", currentDateAndTime);
                user.put("Order_Time",currentDateAndTime1);
                user.put("Order_Date",currentDateAndTime2);
                user.put("TRX_ID", sslcTransactionInfoModel.getTranId());
                documentReference1.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                    @Override
                    public void onSuccess(Void aVoid) {
                        final DocumentReference documentReference2 = fstore.collection("History").document(userID).collection("A").document(currentDateAndTime);
                        documentReference2.addSnapshotListener(DeliveryDetailActivity.this, new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                                Map<String, Object> user = new HashMap<>();
                                user.put("Name", "Unknown");
                                user.put("Mobile", sec_contact);
                                user.put("Road", roadN0);
                                user.put("Uploader_ID", userID);
                                user.put("District", dist);
                                user.put("Address", add2);
                                user.put("PID", pid);
                                user.put("Block", blockNO);
                                user.put("Area", areaNO);
                                user.put("Others", other);
                                user.put("Quantity", quantity);
                                user.put("Price", price);
                                user.put("Total_Price", t_price);
                                user.put("Title", title);
                                user.put("Brand", brand);
                                user.put("Paid", "Paid");
                                user.put("Payment_Type", "SSL");
                                user.put("Status", "Procesing");
                                user.put("SIN", currentDateAndTime);
                                user.put("Order_Time",currentDateAndTime1);
                                user.put("Order_Date",currentDateAndTime2);
                                user.put("TRX_ID",currentDateAndTime);
                                documentReference2.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        progressDialog.dismiss();
                                        Intent intent =new Intent(DeliveryDetailActivity.this,MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        Toast.makeText(DeliveryDetailActivity.this, "Order Is in Processing", Toast.LENGTH_LONG).show();


                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(DeliveryDetailActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                                    }
                                });


                            }
                        });


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(DeliveryDetailActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });
    }

    @Override
    public void transactionFail(String s) {
        Toast.makeText(DeliveryDetailActivity.this, "Failed"+s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void merchantValidationError(String s) {
        Toast.makeText(DeliveryDetailActivity.this, "Failed"+s,Toast.LENGTH_LONG).show();
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3){
            selectedId = deliveryRadioGroup.getCheckedRadioButtonId();
            cash = (RadioButton) findViewById(selectedId);
            Toast.makeText(DeliveryDetailActivity.this, "" +cash.getText(), Toast.LENGTH_LONG).show();

            add2=address.getText().toString();
            dist= district.getText().toString();
            sec_contact=sec_mob.getText().toString();
            roadN0= road.getText().toString();
            blockNO=block.getText().toString();
            areaNO= area.getText().toString();
            other =ps.getText().toString();
            if((address.getText().toString().isEmpty())){
                Toast.makeText(DeliveryDetailActivity.this, "Please enter Address ",Toast.LENGTH_LONG).show();
                return;
            }
            if((district.getText().toString().isEmpty())){
                Toast.makeText(DeliveryDetailActivity.this, "Please enter District ",Toast.LENGTH_LONG).show();
                return;
            }
            if((sec_mob.getText().toString().isEmpty())){
                Toast.makeText(DeliveryDetailActivity.this, "Please enter Mobile ",Toast.LENGTH_LONG).show();
                return;
            }
            if((road.getText().toString().isEmpty())){
                Toast.makeText(DeliveryDetailActivity.this, "Please enter Road/Ward/lane number ",Toast.LENGTH_LONG).show();
                return;
            }

            if((area.getText().toString().isEmpty())){
                Toast.makeText(DeliveryDetailActivity.this, "Please enter Area ",Toast.LENGTH_LONG).show();
                return;
            }
            if((ps.getText().toString().isEmpty())){
                Toast.makeText(DeliveryDetailActivity.this, "Please enter Other Information ",Toast.LENGTH_LONG).show();
                return;
            }

            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
            currentDateAndTime = df.format(new Date())+userID;
            DateFormat df1 = new SimpleDateFormat("HH:mm:ss a", Locale.getDefault());
            currentDateAndTime1 = df1.format(new Date());
            DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
            currentDateAndTime2 = df2.format(new Date());
            if(selectedId==-1){
                Toast.makeText(DeliveryDetailActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                return;
            }
            if(cash.getText().toString().equals("Pay on VISA/Master/Mobile Banking")){
                double a = Double.parseDouble(t_price);
                final SSLCommerzInitialization sslCommerzInitialization = new SSLCommerzInitialization
                        ("sroth610c44d45c861","sroth610c44d45c861@ssl", a , SSLCCurrencyType.BDT,currentDateAndTime,
                                pid, SSLCSdkType.TESTBOX);
                final SSLCCustomerInfoInitializer customerInfoInitializer = new
                        SSLCCustomerInfoInitializer("name", "test@gmail.com",
                        add2, dist, "1214", "Bangladesh",sec_contact);
                IntegrateSSLCommerz
                        .getInstance(DeliveryDetailActivity.this)
                        .addSSLCommerzInitialization(sslCommerzInitialization)
                        .addCustomerInfoInitializer(customerInfoInitializer)
                        .buildApiCall(this);


            }
            else{
                progressDialog.setTitle("Working");
                progressDialog.setTitle("Please wait");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                final DocumentReference documentReference2 = fstore.collection("Processing").document(currentDateAndTime);
                documentReference2.addSnapshotListener(DeliveryDetailActivity.this, new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                        Map<String, Object> user = new HashMap<>();
                        user.put("Name", "Unknown");
                        user.put("Mobile", sec_contact);
                        user.put("Road", roadN0);
                        user.put("Uploader_ID", userID);
                        user.put("District", dist);
                        user.put("Address", add2);
                        user.put("PID", pid);
                        user.put("Block", blockNO);
                        user.put("Area", areaNO);
                        user.put("Others", other);
                        user.put("Quantity", quantity);
                        user.put("Price", price);
                        user.put("Total_Price", t_price);
                        user.put("Title", title);
                        user.put("Brand", brand);
                        user.put("Paid", "Not");
                        user.put("Payment_Type", "COD");
                        user.put("Status", "Procesing");
                        user.put("SIN", currentDateAndTime);
                        user.put("Order_Time",currentDateAndTime1);
                        user.put("Order_Date",currentDateAndTime2);
                        user.put("TRX_ID",currentDateAndTime);
                        documentReference2.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                            @Override
                            public void onSuccess(Void aVoid) {
                                final DocumentReference documentReference20 = fstore.collection("History").document(userID).collection("A").document(currentDateAndTime);
                                documentReference20.addSnapshotListener(DeliveryDetailActivity.this, new EventListener<DocumentSnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                                        Map<String, Object> user = new HashMap<>();
                                        user.put("Name", "Unknown");
                                        user.put("Mobile", sec_contact);
                                        user.put("Road", roadN0);
                                        user.put("Uploader_ID", userID);
                                        user.put("District", dist);
                                        user.put("Address", add2);
                                        user.put("PID", pid);
                                        user.put("Block", blockNO);
                                        user.put("Area", areaNO);
                                        user.put("Others", other);
                                        user.put("Quantity", quantity);
                                        user.put("Price", price);
                                        user.put("Total_Price", t_price);
                                        user.put("Title", title);
                                        user.put("Brand", brand);
                                        user.put("Paid", "Not");
                                        user.put("Payment_Type", "COD");
                                        user.put("Status", "Procesing");
                                        user.put("SIN", currentDateAndTime);
                                        user.put("Order_Time",currentDateAndTime1);
                                        user.put("Order_Date",currentDateAndTime2);
                                        user.put("TRX_ID",currentDateAndTime);
                                        documentReference20.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {


                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                progressDialog.dismiss();
                                                Intent intent =new Intent(DeliveryDetailActivity.this,MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                                Toast.makeText(DeliveryDetailActivity.this, "Order Is in Processing", Toast.LENGTH_LONG).show();


                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                progressDialog.dismiss();
                                                Toast.makeText(DeliveryDetailActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                                            }
                                        });


                                    }
                                });


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(DeliveryDetailActivity.this, "" + e.toString(), Toast.LENGTH_LONG).show();
                            }
                        });


                    }
                });
            }
        }
    }
}
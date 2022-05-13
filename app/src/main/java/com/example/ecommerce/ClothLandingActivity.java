package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ClothLandingActivity extends AppCompatActivity {
    String pid,title,brand,capacity,description,price,last_price;
    CollectionReference collectionReference;
    StorageReference storageReference;
    public FirebaseFirestore fstore;
    ImageView product_image,plus,minus;
    TextView tileT,brandT,desT,priceT,quantity,p_price;
    Button continues;
    double i=1;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_landing);
        progressDialog = new ProgressDialog(ClothLandingActivity.this);
        progressDialog.setTitle("Loading Data");
        progressDialog.setTitle("Loading Photo");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        pid=getIntent().getStringExtra("pid");
        title=getIntent().getStringExtra("title");
        brand=getIntent().getStringExtra("brand");
        capacity=getIntent().getStringExtra("capacity");
        description=getIntent().getStringExtra("description");
        price=getIntent().getStringExtra("price");
        fstore= FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        product_image = findViewById(R.id.imageView69);
        tileT=findViewById(R.id.textView7);
        brandT=findViewById(R.id.textView13);
        desT=findViewById(R.id.textView11);
        priceT=findViewById(R.id.textView16);
        plus=findViewById(R.id.imageView71);
        minus=findViewById(R.id.imageView70);
        quantity=findViewById(R.id.textView14);
        continues=findViewById(R.id.button2);
        p_price=findViewById(R.id.textView10);

        tileT.setText(title);
        brandT.setText(brand);
        desT.setText(description);
        priceT.setText(price);
        p_price.setText(price);

        StorageReference cosmopic = storageReference.child("all_product/"+pid+".jpg");
        cosmopic.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(product_image);
                //Picasso.get().load(uri).into(edit_pic);

                progressDialog.dismiss();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i > 0&& i<11){

                    i++;
                    quantity.setText(String.valueOf(i));
                    double a= Double.parseDouble(price);
                    double total = a*i;
                  last_price=  String.valueOf(total) ;
                    priceT.setText(last_price);

                }

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>1 ){

                    i--;
                    quantity.setText(String.valueOf(i));
                    double a= Double.parseDouble(price);
                    double total = a*i;
                  last_price=  String.valueOf(total);
                  priceT.setText(last_price);

                }
            }
        });
        continues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(ClothLandingActivity.this, DeliveryDetailActivity.class);

                double a= Double.parseDouble(price);
                double total = (a*i)+60;
                last_price=  String.valueOf(total);
                intent4.putExtra("pid",pid);
                intent4.putExtra("title",title);
                intent4.putExtra("brand",brand);
                intent4.putExtra("capacity",capacity);
                intent4.putExtra("description",description);
                intent4.putExtra("price",price);
                intent4.putExtra("Quantity",String.valueOf(i));
                intent4.putExtra("total_price",last_price);
                startActivity(intent4);

            }
        });

        MaterialToolbar toolbar = findViewById(R.id.topAppBarlp);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_lp);
        NavigationView navigationView = findViewById(R.id.navigation_lp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {

                    case R.id.nav_home:
                        Intent intent4 = new Intent(ClothLandingActivity.this, MainActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.order:
                        Intent intent43 = new Intent(ClothLandingActivity.this, OrderHistoryActivity.class);
                        startActivity(intent43);
                        break;


                    case R.id.nav_messenger:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/1558872227740979"));
                        startActivity(intent);   //https://www.facebook.com/EWU.ECPA          //m.me/1558872227740979
                        break;
                    case R.id.nav_facebook:
                        Intent intent11 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1558872227740979"));
                        startActivity(intent11);
                        break;
                    case R.id.nav_cs:
                        String mobCall2 = "tel:+8801406302375";
                        Intent intent12 = new Intent(Intent.ACTION_DIAL);
                        intent12.setData(Uri.parse(mobCall2));
                        startActivity(intent12);
                        break;
                    case R.id.nav_web:

                        break;
                    case R.id.nav_email:


                        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                        /* Fill it with Data */
                        emailIntent.setType("plain/text");
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"srotodhara.18@yahoo.com"});
                        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");

                        /* Send it off to the Activity-Chooser */
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        break;
                    case R.id.store:
                        Uri gmmIntentUri = Uri.parse("geo:23.7922947,90.4157318,21z?q=স্রোতোধারা লেডিস ফ্যাশন, Plot No-15, Pink City Shopping Complex, Gulshan Avenue, Gulshan-2, ঢাকা");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(mapIntent);
                        }
                        break;
                    case R.id.About:
                        Toast.makeText(ClothLandingActivity.this, "About Content Needed",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.women:
                        Intent intent16 = new Intent(ClothLandingActivity.this, WomenActivity2.class);
                        startActivity(intent16);
                        break;
                    case R.id.men:
                        Intent intent2 = new Intent(ClothLandingActivity.this, MenActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.cos:
                        Intent intent3 = new Intent(ClothLandingActivity.this, CosmeticActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent31 = new Intent(ClothLandingActivity.this, LoginwithEmailActivity.class);
                        startActivity(intent31);
                        finish();
                        break;
                    default:
                        return true;

                }
                return true;
            }
        });
    }
}
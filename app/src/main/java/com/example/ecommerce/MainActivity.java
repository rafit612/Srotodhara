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
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     SliderView sliderView;
     int[] images = {R.drawable.one,
     R.drawable.two,R.drawable.three,R.drawable.four
     ,R.drawable.five,R.drawable.six};
     ImageView menc1,menc2,menc3,menc4,menc5,menc6,menc7,menc8,menc9,menc10
             ,wc1,wc2,wc3,wc4,wc5,wc6,wc7,wc8,wc9,wc10,of1,of2,of3,of4,of5,of6
             ,cos,md,wd;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storageReference = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(MainActivity.this);
        menc1=findViewById(R.id.w);
        menc2=findViewById(R.id.w11);
        menc3=findViewById(R.id.w12);
        menc4=findViewById(R.id.w13);
        menc5=findViewById(R.id.w14);
        menc6=findViewById(R.id.w15);
        menc7=findViewById(R.id.w16);
        menc8=findViewById(R.id.w17);
        menc9=findViewById(R.id.w18);
        menc10=findViewById(R.id.w19);

        wc1=findViewById(R.id.w1);
        wc2=findViewById(R.id.w2);
        wc3=findViewById(R.id.w3);
        wc4=findViewById(R.id.w4);
        wc5=findViewById(R.id.w5);
        wc6=findViewById(R.id.w6);
        wc7=findViewById(R.id.w7);
        wc8=findViewById(R.id.w8);
        wc9=findViewById(R.id.w9);
        wc10=findViewById(R.id.w10);

        of1=findViewById(R.id.w20);
        of2=findViewById(R.id.w21);
        of3=findViewById(R.id.w22);
        of4=findViewById(R.id.w23);
        of5=findViewById(R.id.w24);
        of6=findViewById(R.id.w25);

        cos=findViewById(R.id.imageView);
        md=findViewById(R.id.imageView2);
        wd=findViewById(R.id.imageView3);

        cos.setOnClickListener(this);
        md.setOnClickListener(this);
        wd.setOnClickListener(this);
        progressDialog.setTitle("Loading Data");
        progressDialog.setTitle("Please Wait");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        StorageReference profRef_w1 = storageReference.child("women_collection/1.jpeg");

        profRef_w1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc1);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w2 = storageReference.child("women_collection/2.jpeg");

        profRef_w2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc2);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w3 = storageReference.child("women_collection/3.jpeg");

        profRef_w3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc3);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w4 = storageReference.child("women_collection/4.jpeg");

        profRef_w4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc4);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w5 = storageReference.child("women_collection/5.jpeg");

        profRef_w5.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc5);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w6 = storageReference.child("women_collection/6.jpeg");

        profRef_w6.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc6);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w7 = storageReference.child("women_collection/7.jpeg");

        profRef_w7.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc7);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w8 = storageReference.child("women_collection/8.jpeg");

        profRef_w8.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc8);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w9 = storageReference.child("women_collection/9.jpeg");

        profRef_w9.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc9);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_w10 = storageReference.child("women_collection/10.jpeg");

        profRef_w10.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(wc10);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });

        StorageReference profRef_m1 = storageReference.child("men_collection/m1.jpeg");

        profRef_m1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc1);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m2 = storageReference.child("men_collection/m2.jpeg");

        profRef_m2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc2);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m3 = storageReference.child("men_collection/m3.jpeg");

        profRef_m3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc3);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m4 = storageReference.child("men_collection/m4.jpeg");

        profRef_m4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc4);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m5 = storageReference.child("men_collection/m5.jpeg");

        profRef_m5.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc5);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m6 = storageReference.child("men_collection/m6.jpeg");

        profRef_m6.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc6);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m7 = storageReference.child("men_collection/m7.jpeg");

        profRef_m7.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc7);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m8 = storageReference.child("men_collection/m8.jpeg");

        profRef_m8.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc8);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m9 = storageReference.child("men_collection/m9.jpeg");

        profRef_m9.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc9);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_m10 = storageReference.child("men_collection/m10.jpeg");


        StorageReference profRef_of1 = storageReference.child("offer_collection/of1.jpg");

        profRef_of1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(of1);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_of2 = storageReference.child("offer_collection/of2.jpg");

        profRef_of2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(of2);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_of3 = storageReference.child("offer_collection/of3.jpg");

        profRef_of3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(of3);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_of4 = storageReference.child("offer_collection/of4.jpg");

        profRef_of4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(of4);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_of5 = storageReference.child("offer_collection/of5.jpg");

        profRef_of5.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(of5);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        StorageReference profRef_of6 = storageReference.child("offer_collection/of6.jpg");

        profRef_of6.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(of6);
                //Picasso.get().load(uri).into(edit_pic);
                progressDialog.dismiss();

            }
        });


        profRef_m10.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(menc10);
                //Picasso.get().load(uri).into(edit_pic);


            }
        });
        sliderView = findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
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
                        Intent intent4 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.order:
                        Intent intent43 = new Intent(MainActivity.this, OrderHistoryActivity.class);
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
                        Toast.makeText(MainActivity.this, "About Content Needed",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.women:
                        Intent intent16 = new Intent(MainActivity.this, WomenActivity2.class);
                        startActivity(intent16);
                        break;
                    case R.id.men:
                        Intent intent2 = new Intent(MainActivity.this, MenActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.cos:
                        Intent intent3 = new Intent(MainActivity.this, CosmeticActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent31 = new Intent(MainActivity.this, LoginwithEmailActivity.class);
                        startActivity(intent31);
                        finish();
                        break;
                    default:
                        return true;

                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageView) {
            Intent intent = new Intent(MainActivity.this, CosmeticActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.imageView2) {
            Intent intent = new Intent(MainActivity.this, MenActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.imageView3) {
            Intent intent = new Intent(MainActivity.this, WomenActivity2.class);
            startActivity(intent);

        }
    }
}
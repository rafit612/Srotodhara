package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class WomenActivity2 extends AppCompatActivity implements View.OnClickListener {
   ImageView hijab,coat,gown,kurtis,pant,saree,shalwar,shorts,skirt,sweater
           ,top,jacket,under;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women2);
        {
            hijab = findViewById(R.id.imageView29);
            coat = findViewById(R.id.imageView22);
            gown = findViewById(R.id.imageView30);
            kurtis = findViewById(R.id.imageView31);
            pant = findViewById(R.id.imageView32);
            saree = findViewById(R.id.imageView33);
            shalwar = findViewById(R.id.imageView34);
            shorts = findViewById(R.id.imageView35);
            skirt = findViewById(R.id.imageView36);
            sweater = findViewById(R.id.imageView37);
            top = findViewById(R.id.imageView38);
            jacket = findViewById(R.id.imageView39);
            under = findViewById(R.id.imageView40);
        }
        {
            hijab.setOnClickListener(this);
            coat.setOnClickListener(this);
            gown.setOnClickListener(this);
            kurtis.setOnClickListener(this);
            pant.setOnClickListener(this);
            saree.setOnClickListener(this);
            shalwar.setOnClickListener(this);
            shorts.setOnClickListener(this);
            skirt.setOnClickListener(this);
            sweater.setOnClickListener(this);
            top.setOnClickListener(this);
            jacket.setOnClickListener(this);
            under.setOnClickListener(this);
        }
        MaterialToolbar toolbar = findViewById(R.id.topAppBarwomen);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_women);
        NavigationView navigationView = findViewById(R.id.navigation_view_women);
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
                        Intent intent4 = new Intent(WomenActivity2.this, MainActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.order:
                        Intent intent43 = new Intent(WomenActivity2.this, OrderHistoryActivity.class);
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
                        Uri gmmIntentUri = Uri.parse("geo:23.7922705,90.415579");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(mapIntent);
                        }
                        break;
                    case R.id.About:
                        Toast.makeText(WomenActivity2.this, "About Content Needed",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.women:
                        Intent intent16 = new Intent(WomenActivity2.this, WomenActivity2.class);
                        startActivity(intent16);
                        break;
                    case R.id.men:
                        Intent intent2 = new Intent(WomenActivity2.this, MenActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.cos:
                        Intent intent3 = new Intent(WomenActivity2.this, CosmeticActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent31 = new Intent(WomenActivity2.this, LoginwithEmailActivity.class);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageView29) {
            Intent intent4 = new Intent(WomenActivity2.this, HijabActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView22) {
            Intent intent4 = new Intent(WomenActivity2.this, CoatWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView30) {
            Intent intent4 = new Intent(WomenActivity2.this, GownWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView31) {
            Intent intent4 = new Intent(WomenActivity2.this, KurtisWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView32) {
            Intent intent4 = new Intent(WomenActivity2.this, PantsWomenActivity.class);
            startActivity(intent4);


        }
        if (v.getId() == R.id.imageView33) {
            Intent intent4 = new Intent(WomenActivity2.this, SareeActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView34) {
            Intent intent4 = new Intent(WomenActivity2.this, ShalwarKameezActivity2.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView35) {
            Intent intent4 = new Intent(WomenActivity2.this, ShortsWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView36) {
            Intent intent4 = new Intent(WomenActivity2.this, SkirtsActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView37) {
            Intent intent4 = new Intent(WomenActivity2.this, SweaterWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView38) {
            Intent intent4 = new Intent(WomenActivity2.this, TopWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView39) {
            Intent intent4 = new Intent(WomenActivity2.this, JacketsWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView40) {
            Intent intent4 = new Intent(WomenActivity2.this, UnderWearWomenActivity.class);
            startActivity(intent4);

        }
        if (v.getId() == R.id.imageView28) {


        }
    }
}
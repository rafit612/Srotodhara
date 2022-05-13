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

public class CosmeticActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView bb,hair_care,fragnance,skin_care,personal_care,
                men_care,makeup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetic);
        {
            bb = findViewById(R.id.imageView13);
            hair_care = findViewById(R.id.imageView11);
            fragnance = findViewById(R.id.imageView12);
            skin_care = findViewById(R.id.imageView7);
            personal_care = findViewById(R.id.imageView8);
            men_care = findViewById(R.id.imageView9);
            makeup = findViewById(R.id.imageView10);
        }
        {
            bb.setOnClickListener(this);
            hair_care.setOnClickListener(this);
            fragnance.setOnClickListener(this);
            skin_care.setOnClickListener(this);
            personal_care.setOnClickListener(this);
            men_care.setOnClickListener(this);
            makeup.setOnClickListener(this);
        }
        MaterialToolbar toolbar = findViewById(R.id.topAppBarcos);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_cos);
        NavigationView navigationView = findViewById(R.id.navigation_view_cos);
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
                        Intent intent4 = new Intent(CosmeticActivity.this, MainActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.order:
                        Intent intent43 = new Intent(CosmeticActivity.this, OrderHistoryActivity.class);
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
                        Toast.makeText(CosmeticActivity.this, "About Content Needed",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.women:
                        Intent intent16 = new Intent(CosmeticActivity.this, WomenActivity2.class);
                        startActivity(intent16);
                        break;
                    case R.id.men:
                        Intent intent2 = new Intent(CosmeticActivity.this, MenActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.cos:
                        Intent intent3 = new Intent(CosmeticActivity.this, CosmeticActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent31 = new Intent(CosmeticActivity.this, LoginwithEmailActivity.class);
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
        if (v.getId() == R.id.imageView13) {
            Intent intent3 = new Intent(CosmeticActivity.this, BodyandBathActivity.class);
            startActivity(intent3);

        }
        if (v.getId() == R.id.imageView11) {
            Intent intent3 = new Intent(CosmeticActivity.this, HairCareActivity.class);
            startActivity(intent3);


        }
        if (v.getId() == R.id.imageView12) {
            Intent intent3 = new Intent(CosmeticActivity.this, FragnanceActivity.class);
            startActivity(intent3);


        }
        if (v.getId() == R.id.imageView7) {
            Intent intent3 = new Intent(CosmeticActivity.this, SkinCareActivity.class);
            startActivity(intent3);

        }
        if (v.getId() == R.id.imageView8) {

            Intent intent3 = new Intent(CosmeticActivity.this, PersonalCareActivity.class);
            startActivity(intent3);
        }
        if (v.getId() == R.id.imageView9) {
            Intent intent3 = new Intent(CosmeticActivity.this, MenCareActivity.class);
            startActivity(intent3);

        }
        if (v.getId() == R.id.imageView10) {

            Intent intent3 = new Intent(CosmeticActivity.this, MakeupActivity.class);
            startActivity(intent3);
        }

    }
}
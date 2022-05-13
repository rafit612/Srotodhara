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
import com.smarteist.autoimageslider.SliderView;

public class MenActivity extends AppCompatActivity implements View.OnClickListener {
    SliderView sliderView;
    ImageView sweater,punjabi,jackets,hoodi,fatua,coats,underwear,tshirt,suit,shirt,pshirts,pant,kurtas,jeans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);

        sweater=findViewById(R.id.imageView14);
        punjabi=findViewById(R.id.imageView15);
        jackets=findViewById(R.id.imageView16);
        hoodi=findViewById(R.id.imageView17);
        fatua=findViewById(R.id.imageView18);
        coats=findViewById(R.id.imageView19);
        underwear=findViewById(R.id.imageView20);
        tshirt=findViewById(R.id.imageView21);
        suit=findViewById(R.id.imageView23);
        shirt=findViewById(R.id.imageView24);
        pshirts=findViewById(R.id.imageView25);
        pant=findViewById(R.id.imageView26);
        kurtas=findViewById(R.id.imageView27);
        jeans=findViewById(R.id.imageView28);
        {
            sweater.setOnClickListener(this);
            punjabi.setOnClickListener(this);
            jackets.setOnClickListener(this);
            hoodi.setOnClickListener(this);
            fatua.setOnClickListener(this);
            coats.setOnClickListener(this);
            underwear.setOnClickListener(this);
            tshirt.setOnClickListener(this);
            suit.setOnClickListener(this);
            shirt.setOnClickListener(this);
            pshirts.setOnClickListener(this);
            pant.setOnClickListener(this);
            kurtas.setOnClickListener(this);
            jeans.setOnClickListener(this);
        }
        MaterialToolbar toolbar = findViewById(R.id.topAppBarmen);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_men);
        NavigationView navigationView = findViewById(R.id.navigation_view_men);
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
                        Intent intent4 = new Intent(MenActivity.this, MainActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.order:
                        Intent intent43 = new Intent(MenActivity.this, OrderHistoryActivity.class);
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
                        Toast.makeText(MenActivity.this, "About Content Needed",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.women:
                        Intent intent16 = new Intent(MenActivity.this, WomenActivity2.class);
                        startActivity(intent16);
                        break;
                    case R.id.men:
                        Intent intent2 = new Intent(MenActivity.this, MenActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.cos:
                        Intent intent3 = new Intent(MenActivity.this, CosmeticActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent31 = new Intent(MenActivity.this, LoginwithEmailActivity.class);
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
        if (v.getId() == R.id.imageView14) {


        }
        if (v.getId() == R.id.imageView15) {


        }
        if (v.getId() == R.id.imageView16) {


        }
        if (v.getId() == R.id.imageView17) {


        }
        if (v.getId() == R.id.imageView18) {


        }
        if (v.getId() == R.id.imageView19) {


        }
        if (v.getId() == R.id.imageView20) {


        }
        if (v.getId() == R.id.imageView21) {


        }
        if (v.getId() == R.id.imageView23) {


        }
        if (v.getId() == R.id.imageView24) {


        }
        if (v.getId() == R.id.imageView25) {


        }
        if (v.getId() == R.id.imageView26) {


        }
        if (v.getId() == R.id.imageView27) {


        }
        if (v.getId() == R.id.imageView28) {


        }
    }
}

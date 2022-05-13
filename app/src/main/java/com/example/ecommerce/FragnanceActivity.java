package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FragnanceActivity extends AppCompatActivity {
    public static final String EXTRA_PID= "com.hm.roktojoddha.EXTRA_PID";
    public static final String EXTRA_TITLE= "com.hm.roktojoddha.EXTRA_TITLE";
    public static final String EXTRA_BRAND= "com.hm.roktojoddha.EXTRA_BRAND";
    public static final String EXTRA_CAPACITY= "com.hm.roktojoddha.EXTRA_CAPACITY";
    public static final String EXTRA_DESCRIPTION= "com.hm.roktojoddha.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRICE= "com.hm.roktojoddha.EXTRA_PRICE";
    public FirebaseFirestore fstore;

    public RecyclerView recyclerView;
    public ArrayList<String> arrayList_parent;
    public ArrayAdapter<String> arrayAdapter_parent;
    CollectionReference collectionReference;
    StorageReference storageReference;
    FirestoreRecyclerAdapter adapter;
    List<String> cgpa_list = new ArrayList<>();
    public Query query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragnance);



        MaterialToolbar toolbar = findViewById(R.id.topAppBarfrag);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_fragnance);
        NavigationView navigationView = findViewById(R.id.navigation_view_frag);

        fstore=FirebaseFirestore.getInstance();
        collectionReference=fstore.collection("fragnance");
        recyclerView= findViewById(R.id.recyclefrag);
        storageReference = FirebaseStorage.getInstance().getReference();

        arrayList_parent = new ArrayList<>();


        query = fstore.collection("fragnance").orderBy("Price",Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<cosmeticModelClass> options = new FirestoreRecyclerOptions.Builder<cosmeticModelClass>()
                .setQuery(query,cosmeticModelClass.class).build();


        adapter = new FirestoreRecyclerAdapter<cosmeticModelClass, ProductViewHolder>(options) {
            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cosmetic_layout, parent, false);
                return new ProductViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull ProductViewHolder holder, int positions, @NonNull final cosmeticModelClass cosmeticModelClass) {

                holder.title.setText(cosmeticModelClass.getTitle());
                holder.price.setText(cosmeticModelClass.getPrice());
                String pid2= cosmeticModelClass.getPID();
                StorageReference cosmopic = storageReference.child("all_product/"+pid2+".jpg");
                cosmopic.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(holder.product_pic);
                        //Picasso.get().load(uri).into(edit_pic);


                    }
                });


                holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pid= cosmeticModelClass.getPID();
                        String brand = cosmeticModelClass.getBrand();
                        String description = cosmeticModelClass.getDescription();
                        String capacity = cosmeticModelClass.getCapacity();
                        String prices = cosmeticModelClass.getPrice();
                        String titles =cosmeticModelClass.getTitle();
                        Intent intent = new Intent(FragnanceActivity.this,ClothLandingActivity.class);
                        intent.putExtra("pid",pid);
                        intent.putExtra("title",titles);
                        intent.putExtra("brand",brand);
                        intent.putExtra("capacity",capacity);
                        intent.putExtra("description",description);
                        intent.putExtra("price",prices);

                        startActivity(intent);



                    }
                });





            }


        };




        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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
                        Intent intent4 = new Intent(FragnanceActivity.this, MainActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.order:
                        Intent intent43 = new Intent(FragnanceActivity.this, OrderHistoryActivity.class);
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
                        Toast.makeText(FragnanceActivity.this, "About Content Needed",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.women:
                        Intent intent16 = new Intent(FragnanceActivity.this, WomenActivity2.class);
                        startActivity(intent16);
                        break;
                    case R.id.men:
                        Intent intent2 = new Intent(FragnanceActivity.this, MenActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.cos:
                        Intent intent3 = new Intent(FragnanceActivity.this, CosmeticActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent31 = new Intent(FragnanceActivity.this, LoginwithEmailActivity.class);
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

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView title,price;
        ImageView product_pic;
        LinearLayout linearLayout;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            try{
                title = itemView.findViewById(R.id.textView4);
                price = itemView.findViewById(R.id.textView6);
                product_pic = itemView.findViewById(R.id.imageView67);
                linearLayout = itemView.findViewById(R.id.cosmetic_linear);

            } catch (Exception e) {
                Toast.makeText(FragnanceActivity.this, "error= "+e, Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


        }
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
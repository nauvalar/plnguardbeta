package com.valariq.plnguardbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            Intent startIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(startIntent);
            finish();
        }
    }

    public void buattag(View view) {
        Intent intent = new Intent(this, BuatNFCTags.class);
        startActivity(intent);
    }

    public void pengaturanPengguna(View view) {
        Intent intent2 = new Intent(this, PengaturanPengguna.class);
        startActivity(intent2);
    }
}

package com.valariq.plnguardbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PengaturanPengguna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_pengguna);
    }

    public void buatpengguna(View view) {
        Intent buatPenggunaIntent = new Intent(this,BuatUser.class);
        startActivity(buatPenggunaIntent);
    }
}

package com.valariq.plnguardbeta;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.FitWindowsFrameLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BuatUser extends AppCompatActivity {

    private TextInputLayout mNip;
    private TextInputLayout mNama;
    private TextInputLayout mEmail;
    private TextInputLayout mPass;
    private TextInputLayout mConPass;
    private Button mBtnBuat;
    private Button mBtnBatal;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_user);

        mAuth = FirebaseAuth.getInstance();

        mNip = (TextInputLayout)findViewById(R.id.reg_nip);
        mNama = (TextInputLayout)findViewById(R.id.reg_name);
        mEmail = (TextInputLayout)findViewById(R.id.reg_email);
        mPass = (TextInputLayout)findViewById(R.id.reg_password);
        mConPass = (TextInputLayout)findViewById(R.id.reg_confirm_pass);
        mBtnBuat = (Button)findViewById(R.id.btn_buat_bp);
        mBtnBatal = (Button)findViewById(R.id.btn_batal_bp);

        mBtnBuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nip = Integer.parseInt(mNip.getEditText().getText().toString());
                String nama = mNama.getEditText().getText().toString();
                String email = mEmail.getEditText().getText().toString();
                String pass = mPass.getEditText().getText().toString();
                String con_pass = mConPass.getEditText().getText().toString();

                register_user(nip,nama,email,pass);

            }
        });

    }
    private void register_user(int nip, String nama, String email, String pass){
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent mainIntent = new Intent(BuatUser.this, PengaturanPengguna.class);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    Toast.makeText(BuatUser.this,"You got some Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

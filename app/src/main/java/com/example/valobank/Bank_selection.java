package com.example.valobank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bank_selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_selection);

    }

    public void Bdo(View view) {
        Intent bdo = new Intent(Bank_selection.this,BDO_sendform.class);
        startActivity(bdo);
    }

    public void Bpi(View view) {
        Intent bpi = new Intent(Bank_selection.this,BPI_sendform.class);
        startActivity(bpi);
    }

    public void Paymaya(View view) {
        Intent paymaya = new Intent(Bank_selection.this,Paymaya_sendform.class);
        startActivity(paymaya);
    }

    public void Gcash(View view) {
        Intent gcash = new Intent(Bank_selection.this,Gcash_sendform.class);
        startActivity(gcash);
    }
}

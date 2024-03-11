package com.example.valobank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton send, pay, notif, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.send_transfer);
        pay= findViewById(R.id.pay_bills);
        notif = findViewById(R.id.notifs);
        setting = findViewById(R.id.settings);

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent notif = new Intent(new Intent(MainActivity.this,Notification.class));
            startActivity(notif);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(MainActivity.this,Settings.class);
                startActivity(settings);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(MainActivity.this,Pay_on_bill.class);
                startActivity(pay);
            }
        });
    }

    public void send(View view) {
        Intent send = new Intent(MainActivity.this,Bank_selection.class);
        startActivity(send);
    }
}
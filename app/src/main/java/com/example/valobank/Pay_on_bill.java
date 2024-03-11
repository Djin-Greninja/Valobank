package com.example.valobank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pay_on_bill extends AppCompatActivity {
    EditText type, bill, ref, amnt;
    Button pay_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_on_bill);
        type = findViewById(R.id.payment_type);
        bill = findViewById(R.id.biller);
        ref = findViewById(R.id.reference);
        amnt = findViewById(R.id.payment);
        pay_now = findViewById(R.id.pay_btn);

        pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type.getText().toString().isEmpty()|| bill.getText().toString().isEmpty()||ref.getText().toString().isEmpty()||amnt.getText().toString().isEmpty() ){
                    Toast.makeText(Pay_on_bill.this, "Please Enter All Data", Toast.LENGTH_SHORT).show();
                } else {
                    showAlertDialog();
                }
            }
        });
    }

    public void showAlertDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirm Payment");
        alert.setMessage(type.getText().toString() + "\nBiller: " + bill.getText().toString() + "\nRef. no: "+ ref.getText().toString()+ "\nAmount: "
                + amnt.getText().toString());

        alert.setPositiveButton("Proceed Payment", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Pay_on_bill.this, "Payment Successful!", Toast.LENGTH_SHORT).show();
                showReceipt();
                type.getText().clear();
                bill.getText().clear();
                ref.getText().clear();
                amnt.getText().clear();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alert.create().show();
    }

    public void showReceipt(){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Receipt");
        build.setMessage("You Pay Bills to: " + bill.getText().toString()
        + "\nReference Number: "
        + ref.getText().toString() + "\nAmount: "
        + amnt.getText().toString()
        + "\nReceipt Nuum: 893475867312");
        build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Pay_on_bill.this,MainActivity.class);
                startActivity(intent);
            }
        });
        build.create().show();
    }
}
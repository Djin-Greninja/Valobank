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

public class BDO_sendform extends AppCompatActivity {

    EditText nameTxt, nameTxt2, amtTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdo_sendform);


        nameTxt = (EditText) findViewById(R.id.nameTxt);
        nameTxt2 = (EditText) findViewById(R.id.nameTxt2);
        amtTxt = (EditText) findViewById(R.id.amtTxt);

        Button back = (Button) findViewById(R.id.backBtn2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BDO_sendform.this,Bank_selection.class);
                startActivity(intent);
            }
        });



        Button button = (Button) findViewById(R.id.sendBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View onClick) {

                String sendTo = nameTxt.getText().toString();
                String amount = amtTxt.getText().toString();
                String sendName = nameTxt2.getText().toString();

                if (sendTo.isEmpty() || amount.isEmpty() || sendName.isEmpty()) {
                    Toast.makeText(BDO_sendform.this, "Please Enter All Data", Toast.LENGTH_LONG).show();
                } else {
                    showAlertDialog();

                }

            }
        });
    }

    public void sendMoney(View view) {
    }

    public void showAlertDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Proceed to Transfer");
        alert.setMessage("Recipient Name: " + nameTxt2.getText().toString() + "\nRecipient Acc. Number: "
                + nameTxt.getText().toString() + "\nAmount: "
                + amtTxt.getText().toString());
        alert.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(BDO_sendform.this, "Transfer Successful!", Toast.LENGTH_LONG).show();
                showReceipt();
                nameTxt.getText().clear();
                nameTxt2.getText().clear();
                amtTxt.getText().clear();
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
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Receipt");
        alert.setMessage("You Send Money to: " + nameTxt2.getText().toString()
                + "\nAccount Number: "
                + nameTxt.getText().toString() + "\nAmount: "
                + amtTxt.getText().toString()
                + "\nReference Num: 109348712342");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(BDO_sendform.this,MainActivity.class);
                startActivity(intent);
            }
        });
        alert.create().show();
    }

}
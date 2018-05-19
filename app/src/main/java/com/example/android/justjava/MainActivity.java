package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity);

    }

    public void increment(View view) {
        quantity += 1;

    }

    public void decrement(View view) {
        quantity -= 1;

    }

    private void display(int number) {
        TextView quantity = (TextView) findViewById(R.d.quantity_text_view);
        quantity.setText("" + number);

    }

    private void displayPrice(int number) {
        TextView price = (TextView) findViewById(R.d.price_text_view);
        price.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

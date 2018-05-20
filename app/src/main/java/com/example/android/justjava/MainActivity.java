package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    /**
    *variable to hold quantity ordered
    */
    int quantity = 0;

    /**
    *this method grabs the whole element in the activity_main.xml by using setContentView() method. it makes a call to parent class
    *onCreate to set the state
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
    *method to submit order
    */
    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity);

    }
   /**
    *method to increment quantity by 1
    */
    public void increment(View view) {
        quantity += 1;

    }
    
    /**
    *method to decrease quantity by 1
    */

    public void decrement(View view) {
        quantity -= 1;

    }
    
    /**
    *private method to display quantity selected  by users. it get the reference of the id from the template view by 
    *grabing the textview element using findViewById() method and passing the id set in the view. note the (TextView) it cast the 
    *element to of type TextView Class
    */

    private void display(int number) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText("" + number);

    }

    /**
    *private method to calculate the total price of the quantity selected
    */
    private void displayPrice(int number) {
        int quantityPrice = 5;
        TextView price = (TextView) findViewById(R.id.price_text_view);
        price.setText(NumberFormat.getCurrencyInstance().format(number) * quantityPrice);
    }
}

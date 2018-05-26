package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {


    /**
     * variable to hold quantity ordered
     */
    int quantity = 0;


    /**
     * this method grabs the whole element in the activity_main.xml by using setContentView() method. it makes a call to parent class
     * onCreate to set the state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView quantityText = (TextView) findViewById(R.id.quantity_text_view);
        quantityText.setText("" + quantity);
        quantitySelected();

    }

    /**
     * method to submit order; notice the View instance, if you don't pass the View class as an argument to the public method, the
     * xml template will not recognise the function or method.
     */
    public void submitOrder(View view) {
        int price = quantity * 5;
        String priceMessage = "Total: $" + price;
        priceMessage = priceMessage + "\n Thank!";
        displayMessage(priceMessage);


    }

    /**
     * method to increment quantity by 1
     */
    public void increment(View view) {
        quantity += 1;
        display(quantity);
        quantitySelected();

    }

    /**
     * method to decrease quantity by 1
     */

    public void decrement(View view) {
        if(quantity == 0 ){
            quantitySelected();
            return;
        }else {
            quantity -= 1;
            display(quantity);

        }

    }

    /**
     * private method to display quantity selected  by users. it get the reference of the id from the template view by
     * grabing the textview element using findViewById() method and passing the id set in the view. note the (TextView) it cast the
     * element to of type TextView Class
     */

    private void display(int number) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText("" + number);

    }

   
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {

        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * This method displays the quantity selected by the user and also informs them of the price per item.
     */
    private void quantitySelected(){
        String noItemSelected =  "[" + quantity + "]" + "  Item Selected; each Item goes for $5 per item";
        String itemSelected = "[" + quantity + "]" + (quantity == 1 ? " Item" : " Items") + " Selected; each Item goes for $5 per item";
        TextView priceText = (TextView) findViewById(R.id.price_text_view);
        if(quantity == 0) {
           priceText.setText(noItemSelected);
        }else{
            priceText.setText(itemSelected);

        }
    }
}

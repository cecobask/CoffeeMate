package ie.bask.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import ie.bask.R;
import ie.bask.models.Coffee;

public class Add extends Base {

    EditText name, shop, price;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        name = findViewById(R.id.addNameET);
        shop = findViewById(R.id.addShopET);
        price = findViewById(R.id.addPriceET);
        ratingBar = findViewById(R.id.addRatingBar);
    }


    public void addCoffee(View v) {


        String coffeeName = name.getText().toString();
        String coffeeShop = shop.getText().toString();
        double coffeePrice;
        double ratingValue;
        try {
            coffeePrice = Double.parseDouble(price.getText().toString());
        }
        catch(NumberFormatException e){
            coffeePrice = 0.0;
        }
        ratingValue = ratingBar.getRating();


        if ((coffeeName.length() > 0) && (coffeeShop.length() > 0)
                && (price.length() > 0)) {
            Coffee c = new Coffee(coffeeName, coffeeShop, ratingValue,
                    coffeePrice, false);

            Log.v("coffeemate","Add : " + coffeeList);
            coffeeList.add(c);
            startActivity(new Intent(this, Home.class));
        } else
            Toast.makeText(
                    this,
                    "You must Enter Something for "
                            + "\'Name\', \'Shop\' and \'Price\'",
                    Toast.LENGTH_SHORT).show();
    }
}
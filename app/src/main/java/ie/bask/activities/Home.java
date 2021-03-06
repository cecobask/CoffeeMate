package ie.bask.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ie.bask.R;
import ie.bask.fragments.CoffeeFragment;
import ie.bask.models.Coffee;

public class Home extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Information", Snackbar.LENGTH_LONG)
                        .setAction("More Info...", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }
        });
        if(app.coffeeList.isEmpty()) setupCoffees();
    }

    public void add(View v) {
        startActivity(new Intent(this, Add.class));
    }

    public void search(View v) {
        startActivity(new Intent(this, Search.class));
    }

    public void favourites(View v) { startActivity(new Intent(this, Favourites.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        coffeeFragment = CoffeeFragment.newInstance(); //get a new Fragment instance
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, coffeeFragment)
                .commit(); // add it to the current activity
    }

    public void setupCoffees(){
        app.coffeeList.add(new Coffee("Standard Black", "Some Shop",2.5,1.99,false));
        app.coffeeList.add(new Coffee("Regular Joe", "Joe's Place",3.5,2.99,true));
        app.coffeeList.add(new Coffee("Espresso", "Ardkeen Stores",4.5,1.49,true));
    }
}


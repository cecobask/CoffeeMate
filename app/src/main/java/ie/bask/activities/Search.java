package ie.bask.activities;

import android.os.Bundle;

import ie.bask.R;
import ie.bask.fragments.SearchFragment;

public class Search extends Base  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
    }

    @Override
    protected void onResume() {
        super.onResume();

        coffeeFragment = SearchFragment.newInstance(); //get a new Fragment instance
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, coffeeFragment)
                .commit(); // add it to the current activity
    }
}

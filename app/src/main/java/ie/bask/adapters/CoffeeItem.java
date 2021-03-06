package ie.bask.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import ie.bask.R;
import ie.bask.models.Coffee;

public class CoffeeItem {
    View view;

    public CoffeeItem(Context context, ViewGroup parent,
                      View.OnClickListener deleteListener, Coffee coffee)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.coffeerow, parent, false);
        view.setTag(coffee.coffeeId);

        updateControls(coffee);

        ImageView imgDelete = view.findViewById(R.id.rowDeleteImg);
        imgDelete.setTag(coffee);
        imgDelete.setOnClickListener(deleteListener);
    }

    private void updateControls(Coffee coffee) {
        ((TextView) view.findViewById(R.id.rowCoffeeName)).setText(coffee.coffeeName);

        ((TextView) view.findViewById(R.id.rowCoffeeShop)).setText(coffee.shop);
        ((TextView) view.findViewById(R.id.rowRating)).setText(coffee.rating + " *");
        ((TextView) view.findViewById(R.id.rowPrice)).setText("€" +
                new DecimalFormat("0.00").format(coffee.price));

        ImageView imgIcon = view.findViewById(R.id.rowFavouriteImg);

        if (coffee.favourite == true)
            imgIcon.setImageResource(R.drawable.favourites_72_on);
        else
            imgIcon.setImageResource(R.drawable.favourites_72);


    }
}
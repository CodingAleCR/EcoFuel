package info.codingalecr.ecofuel.helpers;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import info.codingalecr.ecofuel.ui.activities.FuelItemFormActivity;

/**
 * Created by Alejandro on 11/26/2017.
 */

public class MainClickHelper {

    public static View.OnClickListener getNewFuelItemClickListener(final Activity activity) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, FuelItemFormActivity.class);
                activity.startActivity(i);
            }
        };
    }

    public static View.OnClickListener getAddRefuel() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }
}

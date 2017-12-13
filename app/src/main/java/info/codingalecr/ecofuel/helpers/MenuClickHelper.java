package info.codingalecr.ecofuel.helpers;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import info.codingalecr.ecofuel.views.activities.FuelListActivity;
import info.codingalecr.ecofuel.views.activities.SettingsActivity;

/**
 * Created by aulate on 12/12/17.
 */

public class MenuClickHelper {

    public static View.OnClickListener getRefuelListClickListener(final Activity activity) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, FuelListActivity.class);
                activity.startActivity(i);
            }
        };
    }

    public static View.OnClickListener getSettingsClickListener(final Activity activity) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, SettingsActivity.class);
                activity.startActivity(i);
            }
        };
    }
}

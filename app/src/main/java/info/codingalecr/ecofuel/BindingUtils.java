package info.codingalecr.ecofuel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aulate on 7/12/17.
 */

public class BindingUtils {

    @BindingAdapter({"bind:showDate"})
    public static void showDate(TextView textView, long time) {
        textView.setText(DateUtils.showDate(time));
    }

    @BindingAdapter({"bind:showKms"})
    public static void showKilometers(TextView textView, float kilometers) {
        textView.setText(String.valueOf(kilometers) + " kms");
    }

    @BindingAdapter({"bind:showCash"})
    public static void showLiters(TextView textView, float liters) {
        textView.setText(String.valueOf(liters) + " colones");
    }
}

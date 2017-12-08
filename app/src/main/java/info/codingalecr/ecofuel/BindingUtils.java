package info.codingalecr.ecofuel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String kmsString = df.format(kilometers) + " kms";
        textView.setText(kmsString);
    }

    @BindingAdapter({"bind:showCash"})
    public static void showCash(TextView textView, float cash) {
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String cashString = df.format(cash) + " colones";
        textView.setText(cashString);
    }

    @BindingAdapter({"bind:showLts"})
    public static void showLiters(TextView textView, float liters) {
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String ltString = df.format(liters) + " lts";
        textView.setText(ltString);
    }
}

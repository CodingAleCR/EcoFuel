package info.codingalecr.refuel;

import android.databinding.BindingAdapter;
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
        String kilometersRes = textView.getResources().getString(R.string.kilometers);

        String kilometersString = String.format(kilometersRes, df.format(kilometers));
        textView.setText(kilometersString);
    }

    @BindingAdapter({"bind:showCash"})
    public static void showCash(TextView textView, float cash) {
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String cashRes = textView.getResources().getString(R.string.cash);

        String cashString = String.format(cashRes, df.format(cash));
        textView.setText(cashString);
    }

    @BindingAdapter({"bind:showLts"})
    public static void showLiters(TextView textView, float liters) {
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String litersRes = textView.getResources().getString(R.string.liters);

        String litersString = String.format(litersRes, df.format(liters));
        textView.setText(litersString);
    }

    @BindingAdapter({"bind:showLitersAbbreviation"})
    public static void showLitersAbbreviation(TextView textView, float liters) {
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String litersRes = textView.getResources().getString(R.string.liters_abbreviation);

        String litersString = String.format(litersRes, df.format(liters));
        textView.setText(litersString);
    }

    @BindingAdapter({"bind:showPerformance"})
    public static void showPerformance(TextView textView, float performance) {
        DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.FLOOR);
        String performanceRes = textView.getResources().getString(R.string.kilometer_per_liter);

        String performanceString = String.format(performanceRes, df.format(performance));
        textView.setText(performanceString);
    }

    @BindingAdapter({"bind:showDaysDifference"})
    public static void showDaysDifference(TextView textView, long startTime, long endTime) {
        String daysRes = textView.getResources().getString(R.string.days_since);
        String daysString = String.format(daysRes, DateUtils.showDateDifferenceInDays(startTime, endTime));
        textView.setText(daysString);
    }
}

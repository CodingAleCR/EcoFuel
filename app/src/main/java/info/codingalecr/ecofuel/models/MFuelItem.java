package info.codingalecr.ecofuel.models;

import info.codingalecr.ecofuel.DateUtils;

/**
 * Created by Alejandro on 11/27/2017.
 */

public class MFuelItem {

    private long mFuelingDate;
    private float mAmountLt;
    private float mAmountCash;
    private float mKilometers;

    public MFuelItem() {
        mFuelingDate = DateUtils.getTime();
    }

    public MFuelItem(long fuelingDate, float amountLt, float amountCash, float kilometers) {
        mFuelingDate = fuelingDate;
        mAmountLt = amountLt;
        mAmountCash = amountCash;
        mKilometers = kilometers;
    }

    public long getFuelingDate() {
        return mFuelingDate;
    }

    public void setFuelingDate(long fuelingDate) {
        mFuelingDate = fuelingDate;
    }

    public float getAmountLt() {
        return mAmountLt;
    }

    public void setAmountLt(float amountLt) {
        mAmountLt = amountLt;
    }

    public float getAmountCash() {
        return mAmountCash;
    }

    public void setAmountCash(float amountCash) {
        mAmountCash = amountCash;
    }

    public float getKilometers() {
        return mKilometers;
    }

    public void setKilometers(float kilometers) {
        mKilometers = kilometers;
    }

    @Override
    public String toString() {
        return "Kms: " + getKilometers() + " / Cash: " + getAmountCash() + " / Liters: " + getAmountLt();
    }
}

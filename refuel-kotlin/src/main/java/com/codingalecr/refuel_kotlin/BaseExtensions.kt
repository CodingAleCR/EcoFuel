package com.codingalecr.refuel_kotlin

import android.widget.DatePicker
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aulate on 5/1/18.
 */
fun TextView.showDate(time: Long) {
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    this.text = simpleDateFormat.format(time)
}

fun TextView.showKilometers(kilometers: Float) {
    val df = DecimalFormat("##.#")
    df.roundingMode = RoundingMode.DOWN
    val kilometersRes = this.resources.getString(R.string.kilometers)

    val kilometersString = String.format(kilometersRes, df.format(kilometers.toDouble()))
    this.text = kilometersString
}

fun TextView.showKilometersAbbreviation(kilometers: Float) {
    val df = DecimalFormat("##.#")
    df.roundingMode = RoundingMode.DOWN
    val kilometersRes = this.resources.getString(R.string.kilometers_abbreviation)

    val kilometersString = String.format(kilometersRes, df.format(kilometers.toDouble()))
    this.text = kilometersString
}

fun TextView.showCash(cash: Float) {
    val df = DecimalFormat("##")
    df.roundingMode = RoundingMode.DOWN
    val cashRes = this.resources.getString(R.string.cash)

    val cashString = String.format(cashRes, df.format(cash.toDouble()))
    this.text = cashString
}

fun TextView.showLiters(liters: Float) {
    val df = DecimalFormat("##.##")
    df.roundingMode = RoundingMode.DOWN
    val litersRes = this.resources.getString(R.string.liters)

    val litersString = String.format(litersRes, df.format(liters.toDouble()))
    this.text = litersString
}

fun TextView.showLitersAbbreviation(liters: Float) {
    val df = DecimalFormat("##.##")
    df.roundingMode = RoundingMode.DOWN
    val litersRes = this.resources.getString(R.string.liters_abbreviation)

    val litersString = String.format(litersRes, df.format(liters.toDouble()))
    this.text = litersString
}

fun TextView.showPerformance(performance: Float) {
    val df = DecimalFormat("##.#")
    df.roundingMode = RoundingMode.FLOOR
    val performanceRes = this.resources.getString(R.string.kilometer_per_liter)

    val performanceString = String.format(performanceRes, df.format(performance.toDouble()))
    this.text = performanceString
}

fun TextView.showDaysDifference(startTime: Long, endTime: Long) {
    val daysRes = this.resources.getString(R.string.days_since)
    val diffTime = endTime - startTime
    val diffDays = diffTime / (1000 * 60 * 60 * 24)
    val daysString = String.format(daysRes, diffDays.toString())
    this.text = daysString
}

fun DatePicker.getDateInMillis(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
    return calendar.timeInMillis
}
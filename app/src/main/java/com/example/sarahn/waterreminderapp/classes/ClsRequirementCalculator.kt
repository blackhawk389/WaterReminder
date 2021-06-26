package com.example.sarahn.waterreminderapp.classes

import android.content.Context
import android.util.Log
import com.example.sarahn.waterreminderapp.Utils.Logging
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import java.lang.Double
import java.text.DecimalFormat

/**
 * Created by SarahN on 6/13/2017.
 */
object ClsRequirementCalculator {
    private var activity: String? = null
    private var climate: String? = null
    var calculated = 0
    var mlToLit = 0.0
    @JvmStatic
    fun calculateRequirement(context: Context?) {
        var climateCal = 0
        var activityCal = 0
        var weight = SharedPrefUtils.getWeight(context).toFloat()
        activity = SharedPrefUtils.getActivityLevel(context)
        climate = SharedPrefUtils.getClimate(context)
        weight = weight / 0.024f
        try {
            climateCal = ClimateCal()
            activityCal = ActivityLevelCal()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("Exception ", " ----$e")
            // Toast.makeText(context, "please enter right information" + e, Toast.LENGTH_SHORT).show();
        }
        calculated = waterInmili(weight, climateCal, activityCal)
        SharedPrefUtils.setRequired(MyApplication.context, calculated)
        mlToLit = mlToLiter(weight, climateCal, activityCal)
    }

    @Throws(Exception::class)
    private fun ActivityLevelCal(): Int {
        var activityCal = 0
        activityCal = when (activity) {
            "Basic Daily Movement With No Excercise" -> 0
            "Daily Routein With Minimal Excercise Of 0-20 Minutes" -> 250
            "Increased Activity With Excercise of 30-60 Minutes" -> 500
            "Strenous Aerobic Or WeightLifting of 60 Minutes" -> 1000
            else -> {
                Logging.logMessage("Activity  " + activity)
                throw Exception("No activity level matched")
            }
        }
        return activityCal
    }

    @Throws(Exception::class)
    private fun ClimateCal(): Int {
        var climateCal = 0
        climateCal = when (climate) {
            "Hot" -> 750
            "Cold" -> 250
            "Moderate" -> 500
            else -> throw Exception("No climate case is match")
        }
        return climateCal
    }

    fun mlToLiter(weight: Float, activityCal: Int, climateCal: Int): kotlin.Double {
        val d = (weight + activityCal + climateCal) / 1000
        val newFormat = DecimalFormat("#.##")
        return Double.valueOf(newFormat.format(d.toDouble()))
    }

    fun mlToGlass(): Int {
        return calculated / 250
    }

    fun waterInmili(weight: Float, activityLevel: Int, climate: Int): Int {
        return weight.toInt() + activityLevel + climate
    }
}
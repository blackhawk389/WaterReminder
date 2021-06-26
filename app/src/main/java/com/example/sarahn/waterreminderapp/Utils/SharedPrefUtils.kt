package com.example.sarahn.waterreminderapp.Utils

import android.content.Context
import android.preference.PreferenceManager
import com.example.sarahn.waterreminderapp.Utils.Logging.logMessage

/**
 * Created by SarahN on 6/6/2017.
 */
object SharedPrefUtils {
    private const val KEY_IS_TRUE = "is_launch_first_time"
    private const val KEY_WEIGHT = "weight"
    private const val KEY_ACTIVITY_LEVEL = "activity_level"
    private const val KEY_CLIMATE = "climate"
    private val userData: IntArray? = null
    private const val DEFAULT_VALUE = 0
    private val DEFUALT_STRING_VALUE: String? = null
    private const val KEY_CONSUMED = "consumed"
    private const val KEY_REMAINED = "remained"
    private const val KEY_REQUIRED = "required"
    private const val KEY_START_HOUR = "start_hour"
    private const val KEY_END_HOUR = "end_hour"
    private const val KEY_START_MIN = "start_min"
    private const val KEY_END_MIN = "end_min"
    private const val KEY_ISBOOT = "is_boot"
    private const val KEY_DURATION = "duration"

    //    public SharedPrefUtils(Context context) {
    //        this.context = context;
    //        sharedPreferences = this.context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0);
    //        editor = sharedPreferences.edit();
    //    }
    @JvmStatic
    @Synchronized
    fun setIsTrue(istrue: Boolean?, context: Context?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_IS_TRUE)
        val editor = prefs.edit()
        editor.putBoolean(KEY_IS_TRUE, istrue!!)
        editor.apply()
    }

    fun getIsTrue(context: Context?): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(KEY_IS_TRUE, true)
    }

    //    synchronized public static void setUserData(Context context, int weight, int activity, int climate){
    //        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    //        SharedPreferences.Editor editor = prefs.edit();
    //        editor.putInt(KEY_WEIGHT,weight);
    //        editor.putInt(KEY_ACTIVITY_LEVEL, activity);
    //        editor.putInt(KEY_CLIMATE, climate);
    //        editor.apply();
    //    }
    @Synchronized
    fun setWeight(context: Context?, weight: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_WEIGHT)
        val editor = prefs.edit()
        editor.putInt(KEY_WEIGHT, weight)
        editor.apply()
    }

    fun getWeight(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_WEIGHT, DEFAULT_VALUE)
    }

    fun getActivityLevel(context: Context?): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(KEY_ACTIVITY_LEVEL, DEFUALT_STRING_VALUE)
    }

    fun getClimate(context: Context?): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(KEY_CLIMATE, DEFUALT_STRING_VALUE)
    }

    @Synchronized
    fun setActivityLevel(context: Context?, activity: String?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_ACTIVITY_LEVEL)
        val editor = prefs.edit()
        editor.putString(KEY_ACTIVITY_LEVEL, activity)
        editor.apply()
    }

    @Synchronized
    fun setClimate(context: Context?, climate: String?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_CLIMATE)
        val editor = prefs.edit()
        editor.putString(KEY_CLIMATE, climate)
        editor.apply()
    }

    @Synchronized
    fun setConsumed(context: Context?, consume: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_CONSUMED)
        val editor = prefs.edit()
        editor.putInt(KEY_CONSUMED, consume)
        editor.apply()
    }

    fun getConsumed(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_CONSUMED, DEFAULT_VALUE)
    }

    @Synchronized
    fun setRemained(context: Context?, consume: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_REMAINED)
        val editor = prefs.edit()
        editor.putInt(KEY_REMAINED, consume)
        editor.apply()
    }

    fun getRemained(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_REMAINED, DEFAULT_VALUE)
    }

    @Synchronized
    fun setRequired(context: Context?, consume: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_REQUIRED)
        val editor = prefs.edit()
        editor.putInt(KEY_REQUIRED, consume)
        editor.apply()
    }

    @Synchronized
    fun setDuration(context: Context?, duration: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_DURATION)
        val editor = prefs.edit()
        editor.putInt(KEY_DURATION, duration)
        editor.apply()
    }

    fun getDuration(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_DURATION, DEFAULT_VALUE)
    }

    fun removeConsumed(context: Context?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        //changing from commit to apply
        prefs.edit().remove(KEY_CONSUMED).apply()
        prefs.edit().remove(KEY_REMAINED).apply()
        logMessage("removed consumed ")
        logMessage("clear---" + getConsumed(context))
        logMessage("clear remained ---" + getRemained(context))
    }

    fun getIsBoot(context: Context?): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(KEY_ISBOOT, false)
    }

    @Synchronized
    fun setIsBoot(context: Context?, boot: Boolean) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_ISBOOT)
        val editor = prefs.edit()
        editor.putBoolean(KEY_ISBOOT, boot)
        editor.apply()
    }

    fun getRequired(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_REQUIRED, DEFAULT_VALUE)
    }

    @Synchronized
    fun setStartHour(context: Context?, consume: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_START_HOUR)
        val editor = prefs.edit()
        editor.putInt(KEY_START_HOUR, consume)
        editor.apply()
    }

    fun getStartHour(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_START_HOUR, DEFAULT_VALUE)
    }

    @Synchronized
    fun setEndHour(context: Context?, consume: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_END_HOUR)
        val editor = prefs.edit()
        editor.putInt(KEY_END_HOUR, consume)
        editor.apply()
    }

    fun getEndHour(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_END_HOUR, DEFAULT_VALUE)
    }

    @Synchronized
    fun setStartMin(context: Context?, consume: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_START_MIN)
        val editor = prefs.edit()
        editor.putInt(KEY_START_MIN, consume)
        editor.apply()
    }

    fun getStartMin(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_START_MIN, DEFAULT_VALUE)
    }

    @Synchronized
    fun setEndMin(context: Context?, consume: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_END_MIN)
        val editor = prefs.edit()
        editor.putInt(KEY_END_MIN, consume)
        editor.apply()
    }

    fun getEndMin(context: Context?): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(KEY_END_MIN, DEFAULT_VALUE)
    } //    synchronized public static void setRequired(Context context, int climate){
    //        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    //        prefs.edit().remove(KEY_CLIMATE);
    //        SharedPreferences.Editor editor = prefs.edit();
    //        editor.putString(, climate);
    //        editor.apply();
    //
    //    }
    //
    //    public static int getRequired(){
    //
    //    }
    //    public static int[] getUserData(Context context){
    //        // how to make lines of code follow synchronization, step by step execution
    //        SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(context);
    //        int weight = prefs.getInt(KEY_WEIGHT, DEFAULT_VALUE);
    //        int activity = prefs.getInt(KEY_ACTIVITY_LEVEL, DEFAULT_VALUE);
    //        int climate = prefs.getInt(KEY_CLIMATE, DEFAULT_VALUE);
    //        userData = new int[]{weight, activity, climate};
    //
    //        return userData;
    //    }
}
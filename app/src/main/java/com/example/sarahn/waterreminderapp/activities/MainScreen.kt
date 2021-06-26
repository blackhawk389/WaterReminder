package com.example.sarahn.waterreminderapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.example.sarahn.waterreminderapp.R
import com.example.sarahn.waterreminderapp.fragments.SettingsFragment
import com.example.sarahn.waterreminderapp.fragments.TodayFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainScreen : AppCompatActivity(), OnTabSelectedListener, TodayFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener {
    private val shareActionProvider: ShareActionProvider? = null
    var tabs: TabLayout? = null
    var ft: FragmentTransaction? = null
    var ivShare: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_main_screen)
        val myToolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        ivShare = findViewById<View>(R.id.iv) as ImageView
        tabs = findViewById<View>(R.id.tabs) as TabLayout
        tabs!!.addTab(tabs!!.newTab().setText("Today"), true)
        tabs!!.addTab(tabs!!.newTab().setText("Settings"))
        tabs!!.setOnTabSelectedListener(this)
        ivShare!!.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app! https://www.dropbox.com/s/mqxitsfwbur2252/app-debug.apk?dl=0")
            //            String shareBody = "Hey check out my app at: www.google.com"  ;
//            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
//            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }
    }

    //    @Override
    //    public boolean onOptionsItemSelected(MenuItem item) {
    //
    //        int id = item.getItemId();
    //
    //        if (id == R.id.action_settings) {
    //
    //            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
    //            sharingIntent.setType("text/plain");
    //
    //            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, download this app! www.google.com");
    ////            String shareBody = "Hey check out my app at: www.google.com"  ;
    ////            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
    ////            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
    //            startActivity(Intent.createChooser(sharingIntent, "Share via"));
    //
    //        }
    //
    //        return super.onOptionsItemSelected(item);
    //    }
    //    @Override
    //    public boolean onCreateOptionsMenu(Menu menu) {
    //        getMenuInflater().inflate(R.menu.menu_main, menu);
    //        return true;
    //    }
    override fun onTabSelected(tab: TabLayout.Tab) {
        when (tabs!!.selectedTabPosition) {
            0 -> {
                val fm = supportFragmentManager
                //including commit
                ft = fm.beginTransaction()
                ft!!.replace(R.id.frame, TodayFragment())
            }
            1 -> {
                val fm1 = supportFragmentManager
                ft = fm1.beginTransaction()
                ft!!.replace(R.id.frame, SettingsFragment())
            }
        }
        ft!!.addToBackStack(null)
        ft!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft!!.commit()
    }

    override fun onTabUnselected(tab: TabLayout.Tab) {}
    override fun onTabReselected(tab: TabLayout.Tab) {}
    override fun onFragmentInteraction(uri: Uri?) {}
    override fun onBackPressed() {

        //  BackpressedDialog.showDialog(this);
        super.onBackPressed()
        moveTaskToBack(true)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}
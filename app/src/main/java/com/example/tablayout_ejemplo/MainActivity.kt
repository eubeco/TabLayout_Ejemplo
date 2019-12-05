package com.example.tablayout_ejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)


        val tabLayout = findViewById<TabLayout>(R.id.appbartabs)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            internal var fragmentTransaction = false
            internal var fragment: Fragment? = null


            override fun onTabSelected(tab: TabLayout.Tab) {

                when (tab.position) {
                    0 -> {
                        fragment = Fragment1()
                        fragmentTransaction = true
                    }
                    1 -> {
                        fragment = Fragment2()
                        fragmentTransaction = true
                    }
                    2 -> {
                        fragment = Fragment3()
                        fragmentTransaction = true
                    }
                }
                if (fragmentTransaction) {
                    supportFragmentManager.beginTransaction().replace(R.id.content_frame, fragment!!).commit()
                    supportActionBar!!.setTitle(tab.text)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }
}

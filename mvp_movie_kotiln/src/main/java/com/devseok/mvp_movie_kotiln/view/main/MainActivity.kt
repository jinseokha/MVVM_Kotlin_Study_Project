package com.devseok.mvp_movie_kotiln.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devseok.mvp_movie_kotiln.R
import com.devseok.mvp_movie_kotiln.util.replace
import com.devseok.mvp_movie_kotiln.view.main.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment: HomeFragment by lazy {
        HomeFragment()
    }

    private val cameraFragment: CameraFragment by lazy {
        CameraFragment().apply {
            arguments = Bundle().apply {
                putInt(CameraFragment.KEY_TITLE, R.string.title_camera)
            }
        }
    }

    private val moveFragment: MoreFragment by lazy {
        MoreFragment().apply {
            arguments = Bundle().apply {
                putInt(MoreFragment.KEY_TITLE, R.string.title_more)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace(R.id.container, homeFragment)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->

        when (item.itemId) {
            R.id.navigation_home -> {
                replace(R.id.container, homeFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_camera -> {
                replace(R.id.container, cameraFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_more -> {
                replace(R.id.container, moveFragment)
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }
}

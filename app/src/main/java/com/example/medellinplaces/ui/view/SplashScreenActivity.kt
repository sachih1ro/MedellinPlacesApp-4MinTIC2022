package com.example.medellinplaces.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.medellinplaces.databinding.ActivityPlacesMainBinding
import com.example.medellinplaces.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    //Handler and runnable definition
    private lateinit var handler : Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Splash Screen Runnable init
        runnable = Runnable {
            val intent = android.content.Intent(
                this,
                com.example.medellinplaces.ui.view.PlacesMainActivity::class.java
            )
            startActivity(intent)
            finish() //Destroy actual activity - (Splash Screen)
        }

        handler = Handler(Looper.getMainLooper())
        handler.postDelayed(runnable,800)
    }

    //Data leak prevention
    override fun onDestroy() {
        //handler.removeCallbacksAndMessages(null)
        handler.removeCallbacks(runnable)
        super.onDestroy()
    }

}
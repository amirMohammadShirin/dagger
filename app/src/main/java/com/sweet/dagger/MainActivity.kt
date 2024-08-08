package com.sweet.dagger

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sweet.dagger.di.DaggerCommandRouterFactory
import com.sweet.dagger.model.router.CommandRouter

class MainActivity : AppCompatActivity() {

    private lateinit var commandRouter: CommandRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initDaggerComponents()

    }

    private fun initDaggerComponents() {
        val commandRouterFactory = DaggerCommandRouterFactory.create()
        commandRouter = commandRouterFactory.router()
    }

    override fun onResume() {
        super.onResume()
        startWithoutUi("deposit amir 500")
    }

    private fun startWithoutUi(input: String) {
        commandRouter.route(input)
        Handler(Looper.getMainLooper()).postDelayed(1000) {
            commandRouter.route("login amir")
        }
    }
}
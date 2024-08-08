package com.sweet.dagger

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sweet.dagger.di.CommandRouterFactory
import com.sweet.dagger.di.DaggerCommandRouterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startWithoutUi("transfer money")

    }

    private fun startWithoutUi(input: String) {

        val commandRouterFactory = DaggerCommandRouterFactory.create()
        val commandRouter = commandRouterFactory.router()

        commandRouter.route(input)

    }
}
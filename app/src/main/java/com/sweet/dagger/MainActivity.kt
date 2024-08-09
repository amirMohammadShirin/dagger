package com.sweet.dagger

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sweet.dagger.di.DaggerCommandProcessorFactory
import com.sweet.dagger.model.router.CommandProcessor

class MainActivity : AppCompatActivity() {

    private lateinit var commandProcessor: CommandProcessor
    private lateinit var btnProcess: Button
    private lateinit var edCommand: EditText
    private lateinit var txtResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        initViews()
        setListeners()
        initDaggerComponents()

    }

    private fun setListeners() {
        btnProcess.setOnClickListener {
            if (this::commandProcessor.isInitialized) {
                val status = commandProcessor.process(edCommand.text.toString())
                txtResponse.text = status.message
            }
        }
    }

    private fun initViews() {
        btnProcess = findViewById(R.id.btnProcess)
        edCommand = findViewById(R.id.edCommand)
        txtResponse = findViewById(R.id.txtResponse)
    }

    private fun initDaggerComponents() {
        val commandRouterFactory = DaggerCommandProcessorFactory.create()
        commandProcessor = commandRouterFactory.processor()
    }

}
package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.TextView

class WatchActivity : AppCompatActivity() {

    private lateinit var stopwatchTextView: TextView
    private lateinit var startButton: ImageButton
    private lateinit var pauseButton: ImageButton
    private lateinit var resetButton: ImageButton

    private var isRunning = false
    private var elapsedTime = 0L
    private var handler: Handler = Handler()
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch)

        stopwatchTextView = findViewById(R.id.stopwatchTextView)
        startButton = findViewById(R.id.startButton)
        pauseButton = findViewById(R.id.pauseButton)
        resetButton = findViewById(R.id.resetButton)

        startButton.setOnClickListener {
            startStopwatch()
        }

        pauseButton.setOnClickListener {
            pauseStopwatch()
        }

        resetButton.setOnClickListener {
            resetStopwatch()
        }
    }

    private fun startStopwatch() {
        isRunning = true
        runnable = Runnable {
            if (isRunning) {
                elapsedTime += 1000
                updateTimer()
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.postDelayed(runnable, 1000)
    }

    private fun pauseStopwatch() {
        isRunning = false
        handler.removeCallbacks(runnable)
    }

    private fun resetStopwatch() {
        isRunning = false
        elapsedTime = 0
        updateTimer()
        handler.removeCallbacks(runnable)
    }

    private fun updateTimer() {
        val hours = (elapsedTime / 3600000).toInt()
        val minutes = ((elapsedTime / 60000) % 60).toInt()
        val seconds = ((elapsedTime / 1000) % 60).toInt()
        stopwatchTextView.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}

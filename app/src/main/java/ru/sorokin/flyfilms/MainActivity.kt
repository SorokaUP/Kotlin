package ru.sorokin.flyfilms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    var stringBuilderLog = StringBuilder()
    private fun initView() {
        stringBuilderLog = StringBuilder()

        gentlyButton.setOnClickListener {
            Counters.gentlyTapped++
            var text = ""
            when (Counters.gentlyTapped) {
                1 -> { text = "Слишком грубо, можно было и нежнее" }
                2 -> { text = "Тебе еще учиться и учиться" }
                3 -> { text = "А еще раз..." }
                else -> { text = "Уиии" }
            }
            printLog(text)
        }

        clearButton.setOnClickListener {
            Counters.gentlyTapped = 0
            printLog("", true)
        }
    }

    private fun printLog(text : String, isBeforeClear : Boolean = false) {
        if (isBeforeClear) {
            stringBuilderLog.clear()
        }

        stringBuilderLog.append(text).append("\n")
        logTextView.setText(stringBuilderLog.toString())
    }
}
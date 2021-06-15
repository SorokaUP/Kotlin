package ru.sorokin.flyfilms

import android.os.Bundle
import android.view.View
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

        gentlyButton.setOnClickListener { onClickGentlyButton(it) }
        clearButton.setOnClickListener { onClickClearButton(it) }
        testButton.setOnClickListener { onClickTestButton(it) }
    }

    private fun printLog(text : String, isBeforeClear : Boolean = false) {
        if (isBeforeClear) {
            stringBuilderLog.clear()
        }

        stringBuilderLog.append(text).append("\n")
        logTextView.setText(stringBuilderLog.toString())
    }

    private fun onClickGentlyButton(it: View) {
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

    private fun onClickClearButton(it: View) {
        Counters.gentlyTapped = 0
        printLog("", true)
    }

    private fun onClickTestButton(it: View) {
        testDataClass()
        testCycle()
    }

    private fun testDataClass() {
        val sorokin = User("Sorokin", true)
        printLog(sorokin.toString())
        val irina = sorokin.copy(login = "Irina")
        printLog(irina.toString())
    }

    private fun testCycle() {
        val marks = arrayOf("Hyundai", "Cherry", "KIA", "Mercedes-Benz", "LADA", "Honda")

        printLog("marks.forEach")
        marks.forEach {
            printLog("  $it")
        }

        printLog("for (i in 0 until marks.size)")
        for (i in 0 until marks.size) {
            printLog("  $i - ${marks[i]}")
        }

        printLog("for (i in marks.indices step 2)")
        for (i in marks.indices step 2) {
            printLog("  $i - ${marks[i]}")
        }

        printLog("for (i in 3..7)")
        for (i in 4..8) {
            printLog("  $i")
        }

        printLog("for (i in 10 downTo 6)")
        for (i in 10 downTo 6) {
            printLog("  $i")
        }
    }
}
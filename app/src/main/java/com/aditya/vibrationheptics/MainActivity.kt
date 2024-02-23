package com.aditya.vibrationheptics

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edittext1 : EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button

    private lateinit var times  : IntArray
    private lateinit var amplitudes : LongArray


    private val numbersList1 = mutableListOf<Int>()
    private val numbersList2 = mutableListOf<Int>()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edittext1 = findViewById(R.id.time)
        editText2 = findViewById(R.id.amplitude)
        button = findViewById(R.id.vibrateButton)

        setupEditTextListener(edittext1, numbersList1)
        setupEditTextListener(editText2, numbersList2)

        val v = getSystemService(VIBRATOR_SERVICE) as Vibrator
        Log.i(
            "================",
            "This device has amplitude control: " + v.hasAmplitudeControl()
        )

        button.setOnClickListener {


            val timearr = LongArray(numbersList1.size)
            val amparr = IntArray(numbersList1.size)

            var totaltime=0

            if (numbersList1.size == numbersList2.size && numbersList1.size>0) {
                var i=0
                var j=0
                for (a in numbersList1) {

                    totaltime=totaltime+a

                    if(totaltime <=15000)
                    {
                        timearr[i] = a.toLong()
                        i++
                    }
                    else
                    {
//                        total time cant be more than 15 Seconds
                        Toast.makeText(this, "total time cant be more than 15 Seconds", Toast.LENGTH_SHORT).show()
                    }


                }
                for (a in numbersList2) {
                    if(a>255 || a < 0)
                    {
//                        amplitude cant be more than 255 or less than 0
                        Toast.makeText(this, "amplitude cant be more than 255 or less than 0", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        amparr[j] = a
                        j++
                    }
                }

                val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // For Android O and above
                    vibrator?.vibrate(VibrationEffect.createWaveform(timearr, amparr, -1))
                }

            }
            else{
//                each time stamp must have its own amplitude
                Toast.makeText(this, "each time stamp must have its own amplitude", Toast.LENGTH_SHORT).show()
            }
            Log.d("@@@" , timearr.toString())
            Log.d("@@@", amparr.toString())
        }
    }

    private fun setupEditTextListener(editText: EditText, numbersList: MutableList<Int>) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    val input = s.toString()
                    if (input.isNotEmpty()) {
                        val parts = input.split(",")
                        numbersList.clear()
                        for (part in parts) {
                            try {
                                val number = part.trim().toInt()
                                numbersList.add(number)
                            } catch (e: NumberFormatException) {
                                // Handle invalid input if needed
                            }
                        }
                    } else {
                        numbersList.clear()
                    }
                }
            }
        })
    }
}
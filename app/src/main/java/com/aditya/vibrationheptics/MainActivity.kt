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
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

//    private lateinit var edittext1 : EditText
//    private lateinit var editText2: EditText
    private lateinit var button: Button
//    private val numbersList1 = mutableListOf<Int>()
//    private val numbersList2 = mutableListOf<Int>()


    val amparr = IntArray(15)
    val bool = BooleanArray(15)



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var count =0
        button = findViewById(R.id.btn)

        val s1: RangeSlider= findViewById(R.id.s1)
        s1.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[0]= value.roundToInt()
            bool[0] = true
        }
        val s2: RangeSlider = findViewById(R.id.s2)
        s2.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[1]= value.roundToInt()
            bool[1] = true

        }
        val s3: RangeSlider = findViewById(R.id.s3)
        s3.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[2]= value.roundToInt()
            bool[2] = true
        }
        val s4: RangeSlider = findViewById(R.id.s4)
        s4.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[3]= value.roundToInt()
            bool[3] = true
        }
        val s5: RangeSlider = findViewById(R.id.s5)
        s5.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[4]= value.roundToInt()
            bool[4] = true
        }
        val s6: RangeSlider = findViewById(R.id.s6)
        s6.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[5]= value.roundToInt()
            bool[5] = true
        }
        val s7: RangeSlider = findViewById(R.id.s7)
        s7.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[6]= value.roundToInt()
            bool[6] = true
        }
        val s8: RangeSlider = findViewById(R.id.s8)
        s8.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[7]= value.roundToInt()
            bool[7] = true
        }
        val s9: RangeSlider = findViewById(R.id.s9)
        s9.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[8]= value.roundToInt()
            bool[8] = true
        }
        val s10: RangeSlider = findViewById(R.id.s10)
        s10.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[9]= value.roundToInt()
            bool[9] = true
        }
        val s11: RangeSlider = findViewById(R.id.s11)
        s11.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[10]= value.roundToInt()
            bool[10] = true
        }
        val s12: RangeSlider = findViewById(R.id.s12)
        s12.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[11]= value.roundToInt()
            bool[11] = true
        }
        val s13: RangeSlider = findViewById(R.id.s13)
        s13.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[12]= value.roundToInt()
            bool[12] = true
        }
        val s14: RangeSlider = findViewById(R.id.s14)
        s14.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[13]= value.roundToInt()
            bool[13] = true
        }
        val s15: RangeSlider = findViewById(R.id.s15)
        s15.addOnChangeListener { slider, value, fromUser ->
            Log.d("@@@" , value.toString())
            amparr[14]= value.roundToInt()
            bool[14] = true
        }

        button.setOnClickListener {

            for (a in bool){
                if (a== true){
                    count++
                }
            }
            Log.d("count" , count.toString())
            var x = 15000/count.toLong()
            var timearr = LongArray(count)
            var newamparr = IntArray(count)

            var c2=0
            var c3=0
            for (a in bool)
            {
                if (a==true)
                {
                    newamparr[c2]= amparr[c3]
                    timearr[c2]= x
                    c2++
                }
                c3++
            }
            Log.d("count" , newamparr.toList().toString())
            Log.d("count" , timearr.toList().toString())

            val v = getSystemService(VIBRATOR_SERVICE) as Vibrator
            v.vibrate(VibrationEffect.createWaveform(timearr, newamparr, -1))


            count=0
        }











//        edittext1 = findViewById(R.id.time)
//        editText2 = findViewById(R.id.amplitude)
//        button = findViewById(R.id.vibrateButton)
//        setupEditTextListener(edittext1, numbersList1)
//        setupEditTextListener(editText2, numbersList2)
//        val v = getSystemService(VIBRATOR_SERVICE) as Vibrator
//        Log.i(
//            "================",
//            "This device has amplitude control: " + v.hasAmplitudeControl()
//        )
//        button.setOnClickListener {
//            val timearr = LongArray(numbersList1.size)
//            val amparr = IntArray(numbersList1.size)
//            var totaltime=0
//            if (numbersList1.size == numbersList2.size && numbersList1.size>0) {
//                var i=0
//                var j=0
//                for (a in numbersList1) {
//                    totaltime=totaltime+a
//                    if(totaltime <=15000)
//                    {
//                        timearr[i] = a.toLong()
//                        i++
//                    }
//                    else
//                    {
////                        total time cant be more than 15 Seconds
//                        Toast.makeText(this, "total time cant be more than 15 Seconds", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                for (a in numbersList2) {
//                    if(a>255 || a < 0)
//                    {
////                        amplitude cant be more than 255 or less than 0
//                        Toast.makeText(this, "amplitude cant be more than 255 or less than 0", Toast.LENGTH_SHORT).show()
//                    }
//                    else {
//                        amparr[j] = a
//                        j++
//                    }
//                }
//
//                val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    // For Android O and above
//                    vibrator?.vibrate(VibrationEffect.createWaveform(timearr, amparr, -1))
//                }
//            }
//            else{
////                each time stamp must have its own amplitude
//                Toast.makeText(this, "each time stamp must have its own amplitude", Toast.LENGTH_SHORT).show()
//            }
//            Log.d("@@@" , timearr.toString())
//            Log.d("@@@", amparr.toString())
//        }
    }

//    private fun setupEditTextListener(editText: EditText, numbersList: MutableList<Int>) {
//        editText.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                // Do nothing
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                // Do nothing
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                s?.let {
//                    val input = s.toString()
//                    if (input.isNotEmpty()) {
//                        val parts = input.split(",")
//                        numbersList.clear()
//                        for (part in parts) {
//                            try {
//                                val number = part.trim().toInt()
//                                numbersList.add(number)
//                            } catch (e: NumberFormatException) {
//                                // Handle invalid input if needed
//                            }
//                        }
//                    } else {
//                        numbersList.clear()
//                    }
//                }
//            }
//        })
//    }
}
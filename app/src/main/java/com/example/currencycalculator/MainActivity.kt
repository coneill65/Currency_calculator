package com.example.currencycalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProfile = findViewById<Button>(R.id.button)
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton)
        val currency = DecimalFormat("##,###.00")
        btnProfile.setOnClickListener{

            val amount = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toFloat()
            val output = findViewById<TextView>(R.id.textView)

            if (radioButton1.isChecked){
                val x = amount * 1.178
                if (x <= 10000){
                output.text = currency.format(x)
                }
                else{
                    Toast.makeText(this@MainActivity, "No values above 10,000 USD is supported.", Toast.LENGTH_LONG)
                }
            }
            else{
                val x = amount * 0.84886
                if (amount <= 10000){
                    output.text = currency.format(x)
                }
                else{
                    Toast.makeText(this@MainActivity, "No values above 10,000 USD is supported.", Toast.LENGTH_LONG)
                }
            }
        }
    }
}
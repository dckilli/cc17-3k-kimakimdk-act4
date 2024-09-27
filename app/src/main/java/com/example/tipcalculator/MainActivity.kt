package com.example.tipcalculator

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity() {
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billAmount = findViewById<EditText>(R.id.billAmount)
        val tipPercentage = findViewById<EditText>(R.id.tipPercentage)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val tipAmount = findViewById<TextView>(R.id.tipAmount)

        calculateButton.setOnClickListener {
            // Get the input values and convert them safely
            val bill = billAmount.text.toString().toDoubleOrNull()
            val tipPercent = tipPercentage.text.toString().toDoubleOrNull()

            // Check if inputs are valid
            if (bill != null && tipPercent != null) {
                // Calculate the tip
                val tip = bill * tipPercent / 100
                // Update the UI with the calculated tip
                tipAmount.text = getString(R.string.tip_amount_placeholder, "%.2f".format(tip))
            } else {
                // Display an error message if inputs are invalid
                tipAmount.text = getString(R.string.invalid_input)
            }
        }
    }
}

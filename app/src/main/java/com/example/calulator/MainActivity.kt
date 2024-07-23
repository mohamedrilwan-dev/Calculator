package com.example.calulator

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBut:Button = findViewById(R.id.addButton)
        val subBut:Button = findViewById(R.id.subButton)
        val mulBut:Button = findViewById(R.id.multiplyButton)
        val devBut:Button = findViewById(R.id.divideButton)

        addBut.setOnClickListener{
            calculate(1)
        }
        subBut.setOnClickListener{
            calculate(2)
        }
        mulBut.setOnClickListener{
            calculate(3)
        }
        devBut.setOnClickListener{
            calculate(4)
        }


    }

    fun calculate(operation : Int)
    {
        var firstNumbertxt = findViewById<EditText>(R.id.firstNumber).text.toString()
        var secondNumbertxt = findViewById<EditText>(R.id.secondNumber).text.toString()

        if(firstNumbertxt.isEmpty() || secondNumbertxt.isEmpty())
        {
          Toast.makeText(this,"Text are empty",Toast.LENGTH_SHORT).show()
            return
        }

         var firstNumber = firstNumbertxt.toIntOrNull()
         var secondNumber = secondNumbertxt.toIntOrNull()

        if(firstNumber !=null && secondNumber !=null)
        {
          val result = when(operation){
              1-> firstNumber + secondNumber
              2-> firstNumber - secondNumber
              3-> firstNumber * secondNumber
              4-> if(secondNumber!=0) firstNumber/secondNumber else {
                 Toast.makeText(this,"Cant divide by zero",Toast.LENGTH_SHORT).show()
                  return
              }
              else ->0
          }
            findViewById<TextView>(R.id.resultText).text = result.toString()
        }
else {
            Toast.makeText(this, "please enter only numbers", Toast.LENGTH_SHORT).show()
      }
    }
}
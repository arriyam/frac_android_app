package com.arriyam.frac.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arriyam.frac.gamemodes.AboutActivity
import com.arriyam.frac.R
import com.arriyam.frac.gamemodes.MathTutorActivity
import com.arriyam.frac.gamemodes.fractionCalculatorModeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculator.setOnClickListener{

            val intent= Intent(this, fractionCalculatorModeActivity::class.java)
            startActivity(intent)

        }

        btnAboutGame.setOnClickListener{

            val intent=Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        btnMathTutor.setOnClickListener{
            val intent=Intent(this,MathTutorActivity::class.java)
            startActivity(intent)
        }
    }
}
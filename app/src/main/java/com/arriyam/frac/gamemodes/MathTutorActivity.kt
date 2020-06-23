package com.arriyam.frac.gamemodes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arriyam.frac.R
import kotlinx.android.synthetic.main.activity_math_tutor.*

class MathTutorActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_tutor)


        btnEasy.setOnClickListener{
            var intent= Intent(this,MathTutorGameActivity::class.java)

            intent.putExtra("Easy","6")
            startActivity(intent)

        }

        btnMedium.setOnClickListener{
            var intent= Intent(this,MathTutorGameActivity::class.java)

            intent.putExtra("Medium","12")
            startActivity(intent)


        }

        btnHard.setOnClickListener{
            var intent= Intent(this,MathTutorGameActivity::class.java)

            intent.putExtra("Hard","20")
            startActivity(intent)

        }



    }
}
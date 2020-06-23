package com.arriyam.frac.gamemodes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arriyam.frac.R
import com.arriyam.frac.leaderboard.UsernameLeaderboardActivity
import com.arriyam.frac.main.MainActivity
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val bundleEx: Bundle?= intent.extras
        val score:String?=bundleEx!!.getString("user_score")
        textViewScore.text="Your Score: $score"

        btnReturnHome.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnPlayAgain.setOnClickListener{
            val intent= Intent(this, MathTutorActivity::class.java)
            startActivity(intent)
        }
        btnLeaderboard.setOnClickListener{
            Toast.makeText(this, "Leaderboard coming soon", Toast.LENGTH_SHORT).show()
//            val intent= Intent(this, UsernameLeaderboardActivity::class.java)
//            intent.putExtra("user_scoreAgain",score)
//            startActivity(intent)
        }
    }
}
package com.arriyam.frac.leaderboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arriyam.frac.R
import com.arriyam.frac.UsernameActivity
import com.arriyam.frac.main.MainActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_username_leaderboard.*

class UsernameLeaderboardActivity:AppCompatActivity() {

    lateinit var editTextName:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username_leaderboard)
        editTextName=findViewById(R.id.editTextPersonUsername)



        val bundleEx: Bundle?= intent.extras
        val score:String?=bundleEx!!.getString("user_scoreAgain")
        val scoreString:String=if (score!=null) score else "0"
        val scoreInt:Int=Integer.parseInt(scoreString)

        btnSubmitUsername.setOnClickListener{
            saveUsername(scoreInt)
            val intent= Intent(this, LeaderboardActivity::class.java)
            startActivity(intent)
        }



    }
    private fun saveUsername(x:Int) {
        var ref = FirebaseDatabase.getInstance().getReference("Username")

        val username = editTextName.text.toString().trim()
        if (username.isEmpty()) {
            Toast.makeText(this, "Enter a Username", Toast.LENGTH_SHORT).show()
            return
        }
//        val user=UsernameActivity(username)

        val usernameId: String = if (ref.push().key != null) ref.push().key!! else "Unknown"

        val user = UsernameActivity(usernameId, username,x)

        ref.child(usernameId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Leaderboard updated", Toast.LENGTH_SHORT).show()
        }
    }
}
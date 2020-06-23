package com.arriyam.frac.leaderboard

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.arriyam.frac.R
import com.arriyam.frac.UsernameActivity
import com.google.firebase.database.*

class LeaderboardActivity: AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var listView: ListView
    lateinit var usernameList: MutableList<UsernameActivity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)
        ref = FirebaseDatabase.getInstance().getReference("Username")
        listView=findViewById(R.id.idListView)
        
    }
}
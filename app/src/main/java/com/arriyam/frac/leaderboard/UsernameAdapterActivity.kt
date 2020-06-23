package com.arriyam.frac.leaderboard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.arriyam.frac.R
import com.arriyam.frac.UsernameActivity
import com.google.firebase.database.core.Context
import com.google.firebase.database.core.view.View

class UsernameAdapterActivity (val mCtx: android.content.Context, val layoutResId:Int, val usernameList:List<UsernameActivity>)
    : ArrayAdapter<UsernameActivity>(mCtx,layoutResId,usernameList){
    override fun getView(position: Int, convertView: android.view.View?, parent: ViewGroup): android.view.View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: android.view.View = layoutInflater.inflate(layoutResId, null)

        val textViewName=view.findViewById<TextView>(R.id.editTextPersonUsername)

        val username=usernameList[position]

        return view

    }
}
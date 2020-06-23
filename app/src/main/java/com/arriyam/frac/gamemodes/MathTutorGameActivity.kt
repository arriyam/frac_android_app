package com.arriyam.frac.gamemodes

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arriyam.frac.R
import com.arriyam.frac.methods.Fraction
import kotlinx.android.synthetic.main.activity_math_tutor_game.*

class MathTutorGameActivity: AppCompatActivity() {

    var count:Int=0
    lateinit var countdown_timer: CountDownTimer
    var isRunning: Boolean = false;
    var timeInMilliseconds = 0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_tutor_game)


        startTimer(60000L)

        lateinit var handler:Handler
        handler=Handler()
        handler.postDelayed({
            val intent= Intent(this, ScoreActivity::class.java)
            val score:String=count.toString()
            intent.putExtra("user_score",score)
            startActivity(intent)
            finish()
        },60000)//60 seconds timer in millisecond  30000




        Toast.makeText(this, "press the reset button to start", Toast.LENGTH_SHORT).show()


        textViewScoreCount.text=count.toString()

        val bundle: Bundle?=intent.extras
//        Choosing between game mode levels
        var x: String?=bundle!!.getString("Easy")
        if (x==null){
            x=bundle!!.getString("Medium")
            if (x==null){
                x=bundle!!.getString("Hard")
            }
        }
        val levelString:String=if (x!=null) x else "Error"
        val level:Int=Integer.parseInt(levelString)

        if (level==6){
            textViewLevel.text="Level Easy"
        }
        else if(level==12){
            textViewLevel.text="Level Medium"
        }
        else textViewLevel.text="Level Hard"



        btnEqualTutor.setOnClickListener{
            Toast.makeText(this, "You must press reset ot start", Toast.LENGTH_SHORT).show()
        }
        btnReset.setOnClickListener {

            operationPut()
            var randomFractionOne: Fraction = randomFraction(level)
            var randomFractionTwo: Fraction = randomFraction(level)
            textSetters(randomFractionOne, randomFractionTwo)
            var unlock=true

            btnEqualTutor.setOnClickListener {
                if (unlock==true) {
                    val numeratorString: String =
                        if (textBoxNumeratorUserInput.text.toString() != "") textBoxNumeratorUserInput.text.toString() else "1"
                    val denominatorString: String =
                        if (textBoxDenominatorUserInput.text.toString() != "") textBoxDenominatorUserInput.text.toString() else "1"
                    var userFraction = Fraction(
                        Integer.parseInt(numeratorString),
                        Integer.parseInt(denominatorString)
                    )
                    if (textViewOperationDisplay.text == "➕") {
                        var correctFraction: Fraction = randomFractionOne.add(randomFractionTwo)
                        equalCheck(correctFraction, userFraction)

                    } else if (textViewOperationDisplay.text == "➖") {
                        var correctFraction: Fraction =
                            randomFractionOne.subtract(randomFractionTwo)
                        equalCheck(correctFraction, userFraction)

                    } else if (textViewOperationDisplay.text == "✖️") {
                        var correctFraction: Fraction =
                            randomFractionOne.multiply(randomFractionTwo)
                        equalCheck(correctFraction, userFraction)

                    } else { //else if (textViewOperationDisplay.text == "➗")
                        var correctFraction: Fraction = randomFractionOne.divide(randomFractionTwo)
                        equalCheck(correctFraction, userFraction)
                    }
                    unlock=false
                }
            }

        }
    }
    fun randomFraction(endRange:Int,startRange:Int=1) : Fraction {
        var randomNumberOne:Int=(Math.random()*(endRange-startRange+1)+startRange).toInt()
        var randomNumberTwo:Int=(Math.random()*(endRange-startRange+1)+startRange).toInt()
        return Fraction(randomNumberOne,randomNumberTwo)
    }
    fun textSetters(randomFractionOne:Fraction, randomFractionTwo:Fraction){
        textBoxRandomNumeratorOne.text = randomFractionOne.getNumerator.toString()
        textBoxRandomDenominatorOne.text = randomFractionOne.getDenominator.toString()
        textBoxRandomNumeratorTwo.text = randomFractionTwo.getNumerator.toString()
        textBoxRandomDenominatorTwo.text = randomFractionTwo.getDenominator.toString()
    }
    fun operationPut(){
        var operationInt:Int=(Math.random()*(4-1+1)+1).toInt()
        if (operationInt==1){
            textViewOperationDisplay.text="➕"
        }
        else if(operationInt==2){
            textViewOperationDisplay.text= "➖"
        }
        else if (operationInt==3){
            textViewOperationDisplay.text="✖️"
        }
        else{
            textViewOperationDisplay.text="➗"
        }
    }
    fun equalCheck(x:Fraction,y:Fraction){
        if (x.semiEquals(y)) {
            textViewDisplayInfo.text = "Correct"
            count+=2
        } else if (x.equals(y)) {
            textViewDisplayInfo.text = " Almost Correct"
            count++
        } else {
            textViewDisplayInfo.text = "Wrong: ${x.toString()}"
        }
        textViewScoreCount.text=count.toString()
    }
//    Updates the timer
    private fun updateUIText() {
        val minute = (timeInMilliseconds / 1000) / 60
        val seconds = (timeInMilliseconds / 1000) % 60
//        $minute:$seconds
        textViewTimer.text = "Timer: $seconds"
    }
// Initials the timer
    private fun startTimer(time_in_seconds: Long) {
        countdown_timer = object : CountDownTimer(time_in_seconds, 1000) {
            override fun onFinish() {
            }

            override fun onTick(p0: Long) {
                timeInMilliseconds = p0
                updateUIText()
            }
        }
        countdown_timer.start()
        isRunning = true

    }
}
package com.arriyam.frac.gamemodes


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arriyam.frac.R
import com.arriyam.frac.methods.Fraction
import kotlinx.android.synthetic.main.activity_fraction_calculator_mode.*


class fractionCalculatorModeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fraction_calculator_mode)


//        Add action
        btnAdd.setOnClickListener{
            textViewShowChosenOperation.text="➕"
        }
//        Subtract action
        btnSubtract.setOnClickListener{
            textViewShowChosenOperation.text="➖"
        }
//        Multiply action
        btnMultiply.setOnClickListener{
            textViewShowChosenOperation.text="✖️"
        }
//        Divide action
        btnDivide.setOnClickListener{
            textViewShowChosenOperation.text="➗"
        }
        btnEqual.setOnClickListener{

            if (textViewShowChosenOperation.text == "") {
                Toast.makeText(this, "Select an Operation", Toast.LENGTH_SHORT).show()
            }
            else if(textBoxDenominatorOne.text.toString()!="0" && textBoxDenominatorTwo.text.toString()!="0") {

                val fra0=userInputToFraction(textBoxNumeratorOne.text.toString(),textBoxDenominatorOne.text.toString())
                val fra1=userInputToFraction(textBoxNumeratorTwo.text.toString(),textBoxDenominatorTwo.text.toString())

                if (textViewShowChosenOperation.text == "➕") {
                    textViewDisplayAnswer.text = "=  " + fra0.add(fra1).toString()
                }
                else if (textViewShowChosenOperation.text == "➖") {
                    textViewDisplayAnswer.text = "=  " + fra0.subtract(fra1).toString()
                }
                else if (textViewShowChosenOperation.text == "✖️") {
                    textViewDisplayAnswer.text = "=  " + fra0.multiply(fra1).toString()
                }
                else if (textViewShowChosenOperation.text == "➗") {
                    if (textBoxNumeratorTwo.text.toString()!="0") {
                        textViewDisplayAnswer.text = "=  " + fra0.divide(fra1).toString()
                    }
                    else{
                        Toast.makeText(this, "Math Error: Can't divide by 0", Toast.LENGTH_SHORT).show()
                        textViewDisplayAnswer.text ="Math Error"
                    }
                }
            }
            else{
                Toast.makeText(this, "Math Error: Can't divide by 0", Toast.LENGTH_SHORT).show()
                textViewDisplayAnswer.text ="Math Error"
            }
        }
    }
    private fun userInputToFraction(numerator: String, denominator:String): Fraction {

        val numeratorString:String=if (numerator!="") numerator else "1"
        val denominatorString:String =if (denominator!="") denominator else "1"

        val numeratorInt:Int=Integer.parseInt(numeratorString)
        val denominatorInt:Int=Integer.parseInt(denominatorString)

        return Fraction(
            numeratorInt,
            denominatorInt
        )
    }
}
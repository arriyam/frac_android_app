package com.arriyam.frac.methods

//    Class, Constructor and State
class Fraction (private var num:Int=0 , private var den: Int=1) {
    init {
        if (den != 0) {
            if (den < 0 && num < 0 || den < 0) {
                num *= -1
                den *= -1
            }
        } else {
            throw IllegalArgumentException("Denominator can't equal 0hen")
        }
    }

    //Getter (variable)
    val getNumerator get() = this.num
    val getDenominator get() = this.den

    //    Methods
    override fun toString(): String = ("$num / $den")

    fun toDouble(): Double = num.toDouble() / den

    private fun toLowestTerm(): Int {
        var a = num
        var b = den
        while (a != 0 && b != 0) {
            val rem = a % b
            a = b
            b = rem
        }
        if (a == 0) a = 1
        return a
    }

    // Method to find the Greatest Common Factor
    private fun gcf(numerator: Int, denominator: Int): Int {
        var a = numerator
        var b = denominator
        while (a != 0 && b != 0) {
            val rem = a % b
            a = b
            b = rem
        }
        if (a == 0) a = 1
        return a
    }

    // Checks if the two fractions are the same
    fun equals(fra: Fraction): Boolean {
        var num0 = toLowestTerm()
        var num1 = gcf(fra.getNumerator, fra.getDenominator)
        val x = num / num0
        val y = den / num0
        val x1 = fra.getNumerator / num1
        val y2 = fra.getDenominator / num1
        return x == x1 && y == y2
    }
    // Checks if the two fractions are identical. It will not find compare the lowest terms form both fraction

    fun semiEquals(fra:Fraction):Boolean{
        return num == fra.getNumerator && den == fra.getDenominator
    }

    //    Operation calculation methods
    fun add(fra: Fraction): Fraction {
        var fraDen = fra.getDenominator
        val x: Int = num * fraDen
        val y: Int = den * fraDen

        val x1: Int = fra.getNumerator * den
        var gcf = gcf(x + x1, y)
        return Fraction((x + x1) / gcf, y / gcf)
    }

    fun subtract(fra: Fraction): Fraction {
        var fraDen = fra.getDenominator
        val x: Int = num * fraDen
        val y: Int = den * fraDen

        val x1: Int = fra.getNumerator * den
        var gcf = gcf(x - x1, y)
        return Fraction((x - x1) / gcf, y / gcf)
    }

    fun multiply(fra: Fraction): Fraction {
        val x: Int = getNumerator * fra.getNumerator
        val y: Int = getDenominator * fra.getDenominator
        val num: Int = gcf(x, y)
        return Fraction(x / num, y / num)
    }

    fun divide(fra: Fraction): Fraction {
        val x: Int = getNumerator * fra.getDenominator
        val y: Int = getDenominator * fra.getNumerator
        val num: Int = gcf(x, y)
        return Fraction(x / num, y / num)
    }

}
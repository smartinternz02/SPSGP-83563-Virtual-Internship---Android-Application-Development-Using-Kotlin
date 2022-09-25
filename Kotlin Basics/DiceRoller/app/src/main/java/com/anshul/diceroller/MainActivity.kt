package com.anshul.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val text : TextView = findViewById(R.id.textView2)
        val diceImage: ImageView = findViewById(R.id.imageView)

        text.setText(diceRoll.toString())

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.one_dice
            2 -> R.drawable.two_dice
            3 -> R.drawable.three_dice
            4 -> R.drawable.four_dice
            5 -> R.drawable.five_dice
            else -> R.drawable.six_dice
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

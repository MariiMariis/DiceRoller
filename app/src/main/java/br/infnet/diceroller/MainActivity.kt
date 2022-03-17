package br.infnet.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var diceImage : ImageView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}

        val contButton: Button = findViewById(R.id.countup_button)
        contButton.setOnClickListener{countup()}

    }

    private fun countup(){
        val textView1: TextView = findViewById(R.id.text_inicial)

        if(textView1.text == "DiceRoller"){
            textView1.text = "1"
        }
        else{
            var resultInt = textView1.text.toString().toInt()

            if (resultInt < 6){
                resultInt++
                textView1.text = resultInt.toString()
            }
        }

    }

    private fun rollDice(){
        val randomInt = (1..6).random()

        val diceImage: ImageView = findViewById(R.id.dice_image)


        var textView1: TextView = findViewById(R.id.text_inicial)
        Toast.makeText(this, "Clicou", Toast.LENGTH_SHORT).show()
        textView1.text = randomInt.toString()

        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        diceImage.setImageResource(drawableResource)

    }
}
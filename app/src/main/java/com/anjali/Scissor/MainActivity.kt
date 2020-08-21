package com.anjali.Scissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var rock:ImageView
    lateinit var scissor:ImageView
    lateinit var humanChoice:TextView
    lateinit var score:TextView
    lateinit var computerChoice:TextView
    lateinit var rocks:Button
    lateinit var papers:Button
    lateinit var scissors:Button
    var  human_score = 0
    var  computer_score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rock = findViewById(R.id.rock)
        scissor = findViewById(R.id.scissor)
        humanChoice = findViewById(R.id.humanChoice)
        score = findViewById(R.id.score)
        computerChoice = findViewById(R.id.computerChoice)
        rocks = findViewById(R.id.rocks)
        papers = findViewById(R.id.papers)
        scissors = findViewById(R.id.scissors)

        rocks.setOnClickListener{
           rock.setImageResource(R.drawable.rockm)
           val message = play_turn("rock")
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
            score.setText("Score Human: " + human_score.toString() + "Computer" + computer_score.toString())

        }
        papers.setOnClickListener{
            rock.setImageResource(R.drawable.paperm)
             val message = play_turn("paper")
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
            score.setText("Score Human: " + human_score.toString() + "Computer" + computer_score.toString())

        }
        scissors.setOnClickListener{
            rock.setImageResource(R.drawable.scisorm)
           val message =  play_turn("scissor")
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
            score.setText("Score Human: " + human_score.toString() + "Computer" + computer_score.toString())

        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState.putInt("human_score",human_score)
        outState.putInt("computer_score",computer_score)
        score.setText("Score Human: " + human_score.toString() + "Computer" + computer_score.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.getInt("human_score")
        savedInstanceState.getInt("computer_score")
    }

    fun play_turn(player_choice:String):String{
        var computerChoice = ""
        val r = Random

        //chose 1 or 2 or 3
        val computer_choice_number = r.nextInt(3)+1//here 3 is not included

        if (computer_choice_number == 1){
            computerChoice = "rock"
        }
        else if(computer_choice_number == 2){
            computerChoice ="scissor"
        }
        else{
            computerChoice = "paper"
        }

        if(computerChoice == "rock"){
            scissor.setImageResource(R.drawable.rockm)
        }
        else if( computerChoice == "paper") {
            scissor.setImageResource(R.drawable.paperm)
        }
        else{
            scissor.setImageResource(R.drawable.scisorm)
        }


        if (computerChoice == player_choice){
            return "draw!! noBody wins"
        }
        else if (player_choice == "rock" && computerChoice == "scissor")
        {
            human_score++
            return "Rock crushes the scissor. You wins!"
        }
        else if (player_choice == "rock" && computerChoice == "paper")
        {
            computer_score++
            return "Paper covers rock. Computer wins!"
        }
        else if (player_choice == "scissor" && computerChoice == "rock")
        {
            computer_score++
            return "Rock crushes the scissor. Computer wins!"
        }
        else if (player_choice == "scissor" && computerChoice == "paper")
        {
            human_score++
            return "Scissor cuts paper. You wins1"
        }
        else if (player_choice == "rock" && computerChoice == "scissor")
        {
            human_score++
            return "Rock crushes the scissor. You win"
        }
        else if (player_choice == "paper" && computerChoice == "rock")
        {
            human_score++
            return "Paper covers rock. You wins!"
        }
        else if (player_choice == "paper" && computerChoice == "scissor")
        {
            computer_score++
            return "Scissor cuts paper. Computer wins1"
        }
        else return "Not Sure??"


    }
}

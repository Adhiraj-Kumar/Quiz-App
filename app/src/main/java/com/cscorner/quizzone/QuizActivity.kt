package com.cscorner.quizzone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cscorner.quizzone.databinding.ActivityQuizBinding
import com.google.android.material.color.utilities.Score

class QuizActivity : AppCompatActivity() {
    private lateinit var binding:ActivityQuizBinding
    private lateinit var list:ArrayList<QuestionModel>
    private var count:Int=0
    private var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list= ArrayList<QuestionModel>()
        list.add(
            QuestionModel("What is the result of 5+'5' in JavaScript?","10","55","5+'5'",
            "Error","55"))
        list.add(QuestionModel("In SQL,whiInch clause is used to filter rows?","SELECT","WHERE","FORM",
            "JOIN","WHERE"))
        list.add(QuestionModel("In javaScript,which keyword is used to declare a variable that cannot be reassinged?","let","var","const",
            "def","const"))
        list.add(QuestionModel("Which data stracture follows the last-in-First-Out principle?","Queue","stack","LinkedList",
            "Array","stack"))
        list.add(QuestionModel("In python Which of the following is a valid variable name?","2myVar","my_Var","@var_nmae",
            "for","my_Var"))



        binding.question.setText(list.get(0).question)
        binding.option1.setText(list.get(0).option1)
        binding.option2.setText(list.get(0).option2)
        binding.option3.setText(list.get(0).option3)
        binding.option4.setText(list.get(0).option4)

        binding.option1.setOnClickListener{
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener{
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener{
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener{
            nextData(binding.option4.text.toString())
        }
    }

    private fun nextData(i: String) {
        if(count<list.size){
        if(list.get(count).ans.equals(i)) {
            score++
        }
        }
        count++
        if(count>=list.size){
            val intent=Intent(this,ScoreActivity::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()
        }
        else {
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }


    }
}
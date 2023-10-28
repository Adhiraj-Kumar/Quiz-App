package com.cscorner.quizzone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cscorner.quizzone.databinding.ActivityLogin2Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.button.setOnClickListener{
            Firebase.auth.createUserWithEmailAndPassword(
                binding.email.editText?.text.toString(),
                binding.password.editText?.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"User Created !!!",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"User not Created !!!",Toast.LENGTH_LONG).show()

                    }
            }
        }
    }
}
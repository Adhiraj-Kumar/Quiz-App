package com.cscorner.quizzone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed(3000) {
            if (Firebase.auth.currentUser != null) {
                val intent = Intent(this,QuizActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity2::class.java)
                intent.putExtra("Mode", "SIGNUP")
                startActivity(intent)

            }
        }
    }
}
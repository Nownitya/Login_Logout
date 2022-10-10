package com.example.login_logout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login_logout.databinding.ActivityGoogleBinding
import com.google.firebase.auth.FirebaseAuth

class GoogleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoogleBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val name = intent.getStringExtra("name")

        binding.emailTV.text = email
        binding.nameTV.text = name


        binding.signOutBTN.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))

        }
    }
}
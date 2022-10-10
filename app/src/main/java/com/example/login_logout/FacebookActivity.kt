package com.example.login_logout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.login_logout.databinding.ActivityFacebookBinding
import com.google.firebase.auth.FirebaseAuth

class FacebookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFacebookBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacebookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        auth = FirebaseAuth.getInstance()


        binding.nameTV.text = auth.currentUser?.displayName
        binding.emailTV.text = auth.currentUser?.email

        binding.signOutBTN.setOnClickListener {
            auth.signOut()
        }

        Log.d(TAG, "FacebookActivity")
    }

    companion object {
        val TAG = FacebookActivity::class.java.simpleName
    }
}
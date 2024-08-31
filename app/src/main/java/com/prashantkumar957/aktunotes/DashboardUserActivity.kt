package com.prashantkumar957.aktunotes

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.prashantkumar957.aktunotes.databinding.ActivityDashboardUserBinding

class DashboardUserActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDashboardUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val email = intent.getStringExtra("email")


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.handcard.setOnClickListener {
            startActivity(Intent(this, HandWritten::class.java))
        }



    }




}

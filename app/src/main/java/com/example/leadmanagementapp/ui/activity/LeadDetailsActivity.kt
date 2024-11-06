package com.example.leadmanagementapp.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.leadmanagementapp.R
import com.example.leadmanagementapp.databinding.ActivityLeadDetailsBinding

class LeadDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeadDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLeadDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener{
            onBackPressed()
        }




    }
}
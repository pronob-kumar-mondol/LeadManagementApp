package com.example.leadmanag

import android.content.Intent
import android.view.WindowManager



import android.os.Build
import android.os.Bundle
import android.provider.Contacts
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leadmanagementapp.R
import com.example.leadmanagementapp.databinding.ActivityLeadBinding
import com.example.leadmanagementapp.databinding.SheetFilterBinding
import com.example.leadmanagementapp.ui.activity.LeadDetailsActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class LeadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeadBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.userInfoClickable.setOnClickListener {
                val intent= Intent(this,LeadDetailsActivity::class.java)
                startActivity(intent)
        }


    }





    }


    /**
    private fun showBottomSheetDialog() {
        val mBehavior= nullsLast<>()
        if (mBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        val view = layoutInflater.inflate(R.layout.sheet_filter, null)

        mBottomSheetDialog = BottomSheetDialog(this)
        mBottomSheetDialog?.setContentView(view)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBottomSheetDialog?.window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        mBottomSheetDialog?.show()
        mBottomSheetDialog?.setOnDismissListener {
            mBottomSheetDialog = null
        }
    } **/

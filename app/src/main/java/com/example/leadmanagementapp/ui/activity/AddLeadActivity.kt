package com.example.leadmanagementapp.ui.activity


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import com.example.leadmanagementapp.MainActivity
import com.example.leadmanagementapp.R
import com.example.leadmanagementapp.databinding.ActivityAddLeadBinding

class AddLeadActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddLeadBinding
    private val PICK_IMAGE_REQUEST = 1

    override fun onResume() {
        super.onResume()

        val projects_name=resources.getStringArray(R.array.project)
        val district=resources.getStringArray(R.array.District)
        val interest=resources.getStringArray(R.array.Interest)


        val projects_nameArrayAdapter=ArrayAdapter(this,R.layout.dropdown_item,projects_name)
        val districtArrayAdapter=ArrayAdapter(this,R.layout.dropdown_item,district)
        val interestArrayAdapter=ArrayAdapter(this,R.layout.dropdown_item,interest)


        binding.projectName.setAdapter(projects_nameArrayAdapter)
        binding.districtName.setAdapter(districtArrayAdapter)
        binding.interest.setAdapter(interestArrayAdapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityAddLeadBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnAdd.isInvisible=true

        binding.btnBack?.setOnClickListener { finish() }





        binding.addLeadBtn.setOnClickListener {
            //The data will be posted in Api

            if (!validateData()){
                return@setOnClickListener
            }else{
                val intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        binding.btnChooseFileLayout.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }
        binding.btnChooseFile.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }





    }





    private fun validateData(): Boolean {
        var isValid = true

        if (binding.organizationName.text.toString().isEmpty()) {
            binding.textInputLayout1.error = "Organization Name is required"
            isValid = false
        } else {
            binding.textInputLayout1.error = null // Clear error if not empty
        }

        if (binding.projectName.text.toString().isEmpty()) {
            binding.textInputLayout3.error = "Project Name is required"
            isValid = false
        } else {
            binding.textInputLayout3.error = null
        }

        if (binding.districtName.text.toString().isEmpty()) {
            binding.textInputLayout4.error = "District Name is required"
            isValid = false
        } else {
            binding.textInputLayout4.error = null
        }

        if (binding.address.text.toString().isEmpty()) {
            binding.textInputLayout9.error = "Address is required"
            isValid = false
        } else {
            binding.textInputLayout9.error = null
        }

        return isValid
    }



}
package com.example.leadmanagementapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.leadmanagementapp.databinding.FragmentAddAlertBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddAlertBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddAlertBottomSheetBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onResume() {
        super.onResume()
        val select_alert_type=resources.getStringArray(R.array.alert_type)
        val arrayAdapter= ArrayAdapter(requireContext(),R.layout.dropdown_item,select_alert_type)
        binding.selectAlertOrMsg.setAdapter(arrayAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Show the Date Picker when the Alert type is selected
        binding.selectAlertOrMsg.setOnItemClickListener { _, _, _, _ ->
            val alertType = binding.selectAlertOrMsg.text.toString()
            Log.d("alert_type", alertType)

            // Toggle visibility of Date Picker based on selection
            if (alertType.equals("Alert", ignoreCase = true)) {
                binding.alertDatePicker.visibility = View.VISIBLE
            } else {
                binding.alertDatePicker.visibility = View.GONE
            }
        }

        binding.alertDate.setOnClickListener{
            showDatePickerDialog()
        }

    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->

                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                binding.alertDate.setText(selectedDate)

            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddAlertBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

}
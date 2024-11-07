package com.example.leadmanagementapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leadmanag.LeadActivity
import com.example.leadmanagementapp.Data.DemoData
import com.example.leadmanagementapp.R
import com.example.leadmanagementapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
/**
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
**/


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val demoData= listOf(
            DemoData(R.drawable.google_demo_img, "Google", "Alert","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Facebook", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Twiter", "Alert","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Whatsapp", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Tiktok", "Alert","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Skype", "Massage","10:45 Am"),
            DemoData(R.drawable.google_demo_img, "Redit", "Alert","10:45 Am")
        )


        binding.leadRcView.layoutManager= LinearLayoutManager(requireContext())
        binding.leadRcView.adapter= HomeAdapter(demoData,this)




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(item: DemoData) {
        val intent = Intent(requireContext(), LeadActivity::class.java)
        startActivity(intent)
    }
}
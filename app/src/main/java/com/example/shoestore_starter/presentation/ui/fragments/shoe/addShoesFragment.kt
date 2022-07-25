package com.example.shoestore_starter.presentation.ui.fragments.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentAddShoesBinding
import com.example.shoestore_starter.models.Shoe
import java.time.Duration

class addShoesFragment : Fragment() {

    lateinit var binding:FragmentAddShoesBinding
    lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_shoes, container, false)
        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this
        binding.shoeItem = Shoe()
        shoeViewModel.navigateBack.observe(viewLifecycleOwner) {
            if (it) requireActivity().onBackPressed()
        }

        binding.addBtn.setOnClickListener{ addNewShoes()}
        binding.cancelBtn.setOnClickListener{ requireActivity().onBackPressed()}

        return binding.root
    }

    private fun addNewShoes() {

    }

}
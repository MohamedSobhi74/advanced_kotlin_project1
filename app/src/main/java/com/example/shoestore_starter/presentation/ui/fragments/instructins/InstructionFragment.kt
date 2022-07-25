package com.example.shoestore_starter.presentation.ui.fragments.instructins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    lateinit var binding:FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction, container, false)

        binding.continueBtn.setOnClickListener { findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment) }
        return binding.root
    }

}
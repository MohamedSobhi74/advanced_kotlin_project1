package com.example.shoestore_starter.presentation.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)

        binding.loginBtn.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment) }
        return binding.root
    }

}
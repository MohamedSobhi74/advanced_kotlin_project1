package com.example.shoestore_starter.presentation.ui.fragments.shoe

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentShoeListBinding
import com.example.shoestore_starter.databinding.ShoeItemBinding
import com.example.shoestore_starter.models.Shoe


class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoeListBinding
    lateinit var shoeViewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        shoeViewModel.shoeLiveData.observe(viewLifecycleOwner) { shoesList ->
            inflateShoeItems(
                shoesList
            )
        }
        binding.addShoesBtn.setOnClickListener { findNavController().navigate(R.id.action_shoeListFragment_to_addShoesFragment) }
        return binding.root
    }

    private fun inflateShoeItems(shoesList: MutableList<Shoe>?) {


        shoesList!!.forEach { shoeItem ->
            (view as? ViewGroup)?.let {
                var shoeBinding: ShoeItemBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, it, false)
                shoeBinding.shoeItem = shoeItem
                // val v = layoutInflater.inflate( R.layout.shoe_item, it,false)
                binding.linearViewGroup.addView(shoeBinding.root)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.actions_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_shoeListFragment_to_loginFragment) {
            logout()
        }

        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun logout() {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
    }

}
package com.example.shoestore_starter.presentation.ui.fragments.shoe

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore_starter.models.Shoe

class ShoeViewModel : ViewModel() {

    val errorMessage: MutableLiveData<String>
        get() = _showMessage
    protected val _showMessage: MutableLiveData<String> = MutableLiveData()

    val navigateBack: MutableLiveData<Boolean>
        get() = _navigateBack
    protected val _navigateBack: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _shoeMutableLiveData = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    val shoeLiveData: LiveData<MutableList<Shoe>>
        get() = _shoeMutableLiveData


    init {
        retrieveShoeList()
    }

    private fun retrieveShoeList() {
        _shoeMutableLiveData.value?.add(Shoe("nike",20.0,"Nike","comfortable and flexible shoe"))
        _shoeMutableLiveData.value?.add(Shoe("adidas",50.0,"Adidas","comfortable and flexible shoe"))
        _shoeMutableLiveData.value?.add(Shoe("reebok",65.0,"Reebok","comfortable and flexible shoe"))

    }

    fun addNewShoes(shoe: Shoe) {

        if (shoe.name.isEmpty()
            ||shoe.company.isEmpty()
            ||shoe.size == 0.0
            ||shoe.description.isEmpty()
        ){

            _showMessage.value = "please complete all shoes info"
            return
        }

        _shoeMutableLiveData.value?.add(shoe)
        _navigateBack.value = true
    }

}
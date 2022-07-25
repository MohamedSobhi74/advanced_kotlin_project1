package com.example.shoestore_starter.presentation.utils

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter

import com.google.android.material.snackbar.Snackbar

@BindingAdapter("toastMessage")
fun toastMessage(view: View, msg: String?) {
    if (!msg.isNullOrBlank()) Toast.makeText(view.context,msg,Toast.LENGTH_LONG).show()
}

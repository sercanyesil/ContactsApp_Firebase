package com.example.contactsapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.doNavigation(it:View, id:Int) {
    findNavController(it).navigate(id)
}

fun Navigation.doNavigation(it:View, id:NavDirections) {
    findNavController(it).navigate(id)
}


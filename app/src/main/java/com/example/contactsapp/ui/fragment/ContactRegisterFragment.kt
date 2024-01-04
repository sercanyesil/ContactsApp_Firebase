package com.example.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentContactRegisterBinding
import com.example.contactsapp.ui.viewmodel.ContactRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactRegisterFragment : Fragment() {
    private lateinit var binding: FragmentContactRegisterBinding
    private lateinit var viewModel: ContactRegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_register, container, false)
        binding.contactRegisterFragment = this
        binding.contactRegisterToolbarTitle = "Contact Register"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ContactRegisterViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSave(contact_name: String, contact_number: String) {
        viewModel.save(contact_name, contact_number)
    }

}
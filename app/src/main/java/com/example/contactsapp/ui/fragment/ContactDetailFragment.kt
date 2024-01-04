package com.example.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentContactDetailBinding
import com.example.contactsapp.ui.viewmodel.ContactDetailViewModel
import com.example.contactsapp.ui.viewmodel.ContactRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactDetailFragment : Fragment() {
    private lateinit var binding: FragmentContactDetailBinding
    private lateinit var viewModel: ContactDetailViewModel
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_contact_detail, container, false)
        binding.contactDetailFragment = this
        binding.contactDetailToolbarTitle = "Contact Detail"

        val bundle: ContactDetailFragmentArgs by navArgs()
        val comerContact = bundle.contact

        binding.contactObject = comerContact

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ContactDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(contact_id:String, contact_name: String, contact_number: String) {
        viewModel.update(contact_id, contact_name, contact_number)
    }

}
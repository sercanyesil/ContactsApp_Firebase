package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactDetailViewModel @Inject constructor(var crepo: ContactsRepository) : ViewModel() {

    fun update(contact_id: String , contact_name: String, contact_number: String) {
            crepo.update(contact_id,contact_name,contact_number)
    }
}
package com.example.contactsapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.entity.Contacts

class ContactsRepository(var cds:ContactsDataSource) {

    fun save(contact_name: String, contact_number: String) = cds.save(contact_name, contact_number)

    fun update(contact_id:String, contact_name: String, contact_number: String) = cds.update(contact_id, contact_name, contact_number)

    fun delete(contact_id:String) = cds.delete(contact_id)

    fun loadContacts() : MutableLiveData<List<Contacts>> = cds.loadContacts()

    fun search(searchWord: String) : MutableLiveData<List<Contacts>> = cds.search(searchWord)
}
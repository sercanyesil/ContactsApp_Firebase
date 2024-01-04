package com.example.contactsapp.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactsapp.data.entity.Contacts
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var collectionContacts: CollectionReference) {
    var contactList = MutableLiveData<List<Contacts>>()

    fun loadContacts() : MutableLiveData<List<Contacts>> {
        collectionContacts.addSnapshotListener { value, error ->
            if (value != null) {
                val list = ArrayList<Contacts>()

                for (d in value.documents) {
                    val contact = d.toObject(Contacts::class.java)
                    if(contact != null) {
                        contact.contact_id = d.id
                        list.add(contact)
                    }
                }

                contactList.value = list
            }
        }
        return contactList
    }

    fun search(searchWord: String) : MutableLiveData<List<Contacts>>  {
        collectionContacts.addSnapshotListener { value, error ->
            if (value != null) {
                val list = ArrayList<Contacts>()

                for (d in value.documents) {
                    val contact = d.toObject(Contacts::class.java)
                    if(contact != null) {
                        if(contact.contact_name!!.lowercase().contains(searchWord.lowercase())) {
                            contact.contact_id = d.id
                            list.add(contact)
                        }
                    }
                }

                contactList.value = list
            }
        }
        return contactList
    }

    fun save(contact_name: String, contact_number: String) {
        val newContact = Contacts("", contact_name, contact_number)
        collectionContacts.document().set(newContact)
    }

    fun update(contact_id:String, contact_name: String, contact_number: String) {
        val updatedContact = HashMap<String, Any>()
        updatedContact["contact_name"] = contact_name
        updatedContact["contact_number"] = contact_number
        collectionContacts.document(contact_id).update(updatedContact)
    }

    fun delete(contact_id:String) {
        collectionContacts.document(contact_id).delete()
    }
}
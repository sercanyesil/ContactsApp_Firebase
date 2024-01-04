package com.example.contactsapp.data.entity

import java.io.Serializable

class Contacts(var contact_id:String? = "",
               var contact_name:String? = "",
               var contact_number: String? = "") : Serializable {
}
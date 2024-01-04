package com.example.contactsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBinderMapper
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.R
import com.example.contactsapp.data.entity.Contacts
import com.example.contactsapp.databinding.CardDesignBinding
import com.example.contactsapp.databinding.FragmentHomePageBinding
import com.example.contactsapp.ui.fragment.HomePageFragmentDirections
import com.example.contactsapp.ui.viewmodel.HomepageViewModel
import com.example.contactsapp.util.doNavigation
import com.google.android.material.snackbar.Snackbar

class ContactsAdapter(var mContext: Context, var contactList:List<Contacts>, var viewModel: HomepageViewModel)
    : RecyclerView.Adapter<ContactsAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design:CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding: CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_design, parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val contact = contactList.get(position)
        val t = holder.design

        t.contactObject = contact

        t.textViewContactName.text = contact.contact_name
        t.textViewContactNumber.text = contact.contact_number

        t.cardViewRow.setOnClickListener {
            val navigate = HomePageFragmentDirections.contactDetailNavigate(contact = contact)
            Navigation.doNavigation(it, navigate)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "${contact.contact_name} will removed, are you sure?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.delete(contact.contact_id!!)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}
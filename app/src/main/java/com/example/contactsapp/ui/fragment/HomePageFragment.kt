package com.example.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.contactsapp.R
import com.example.contactsapp.data.entity.Contacts
import com.example.contactsapp.databinding.FragmentHomePageBinding
import com.example.contactsapp.ui.adapter.ContactsAdapter
import com.example.contactsapp.ui.viewmodel.ContactDetailViewModel
import com.example.contactsapp.ui.viewmodel.HomepageViewModel
import com.example.contactsapp.util.doNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: HomepageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        binding.homePageFragment = this

        binding.homePageToolbarTitle = "Contacts"

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        //binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        viewModel.contactList.observe(viewLifecycleOwner) {
            val contactsAdapter = ContactsAdapter(requireContext(), it, viewModel)
            binding.contactAdapter = contactsAdapter
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.search(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    viewModel.search(newText)
                }
                return true
            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(it:View) {
        Navigation.doNavigation(it, R.id.contactRegisterNavigate)
    }
}
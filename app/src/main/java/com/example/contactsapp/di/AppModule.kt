package com.example.contactsapp.di

import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.repo.ContactsRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsDataSource(collectionContacts:CollectionReference) : ContactsDataSource {
        return ContactsDataSource(collectionContacts)
    }

    @Provides
    @Singleton
    fun provideContactsRepository(cds: ContactsDataSource) : ContactsRepository {
        return ContactsRepository(cds)
    }

    @Provides
    @Singleton
    fun provideCollectionReference() : CollectionReference {
        return Firebase.firestore.collection("Contacts")
    }

}
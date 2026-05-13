package com.example.ecommerce.firebaseInstance

import com.example.ecommerce.data.repo.Authrepo
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Firebaseinstance {



    @Provides
    @Singleton

    fun authservice(): FirebaseAuth{

       return FirebaseAuth.getInstance()

    }


   @Provides

   @Singleton

   fun authrepo(): Authrepo{

       return Authrepo(FirebaseAuth.getInstance())

   }


}
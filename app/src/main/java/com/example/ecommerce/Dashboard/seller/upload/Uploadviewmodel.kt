package com.example.ecommerce.Dashboard.seller.upload

import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerce.Dashboard.seller.Model.Pmodel
import com.example.ecommerce.Dashboard.seller.repo.SellerRepository
import com.example.ecommerce.DataState
import com.example.ecommerce.data.authservice.SellerService
import com.example.ecommerce.data.model.Regmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Uploadviewmodel @Inject
constructor(

   private val sellerRepo: SellerRepository

): ViewModel() {

    private val _imageupload = MutableLiveData<DataState<String>>()

    val imageupload: LiveData<DataState<String>> = _imageupload


    fun productupload(pmodel: Pmodel){

        _imageupload.postValue(DataState.Loading())

        val imageuri: Uri = pmodel.imagelink.toUri()

        sellerRepo.imageuploaduri(imageuri).addOnSuccessListener {snapshot ->

          snapshot.metadata?.reference?.downloadUrl?.addOnSuccessListener { uri ->

              pmodel.imagelink = uri.toString()

              sellerRepo.productupload(pmodel).addOnSuccessListener {

                  _imageupload.postValue(DataState.Success("task done"))

              }.addOnFailureListener { error->

                  _imageupload.postValue(DataState.Error(error.message.toString()))



              }
          }

        }.addOnFailureListener { error->

           _imageupload.postValue(DataState.Error(error.message.toString()))

        }


    }

}
package com.example.ecommerce.Dashboard.seller.repo

import android.annotation.SuppressLint
import android.net.Uri
import com.google.firebase.storage.StorageReference
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.DialogFragment
import com.example.ecommerce.Notes
import com.example.ecommerce.data.authservice.SellerService
import com.google.firebase.storage.UploadTask
import javax.inject.Inject


class SellerRepository @Inject constructor(

    private val storageRef: StorageReference

): SellerService {

    @SuppressLint("SuspiciousIndentation")
    override fun imageuploaduri(imageuri: Uri): UploadTask {

        val storage: StorageReference = storageRef.child(Notes.storagepath)

            .child("PRD_${System.currentTimeMillis()}")


          return storage.putFile(imageuri)

    }


}
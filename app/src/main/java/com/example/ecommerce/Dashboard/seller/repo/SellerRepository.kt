package com.example.ecommerce.Dashboard.seller.repo

import android.annotation.SuppressLint
import android.net.Uri
import com.google.firebase.storage.StorageReference
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.DialogFragment
import com.example.ecommerce.Dashboard.seller.Model.Pmodel
import com.example.ecommerce.Notes
import com.example.ecommerce.data.authservice.SellerService
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.UploadTask
import javax.inject.Inject


class SellerRepository @Inject constructor(

    private val storageRef: StorageReference,

    private val db: FirebaseFirestore

): SellerService {

    @SuppressLint("SuspiciousIndentation")
    override fun imageuploaduri(imageuri: Uri): UploadTask {

        val storage: StorageReference = storageRef.child(Notes.storagepath)

            .child("PRD_${System.currentTimeMillis()}")


          return storage.putFile(imageuri)

    }

    override fun productupload(pmodel: Pmodel): Task<Void> {

     return   db.collection(Notes.PRODUCT)
            .document().set(pmodel)

    }


}
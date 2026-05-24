package com.example.ecommerce.data.authservice

import android.net.Uri
import com.example.ecommerce.Dashboard.seller.Model.Pmodel
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.UploadTask

interface SellerService {

    fun imageuploaduri(imageuri: Uri): UploadTask

    fun productupload(pmodel: Pmodel): Task<Void>

}
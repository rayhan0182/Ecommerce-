package com.example.ecommerce.data.authservice

import android.net.Uri
import com.google.firebase.storage.UploadTask

interface SellerService {

    fun imageuploaduri(imageuri: Uri): UploadTask

}
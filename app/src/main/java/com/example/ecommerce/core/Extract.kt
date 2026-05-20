package com.example.ecommerce.core
import android.content.pm.PackageManager
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun EditText.extrasyntex(): String{

   return this.text.toString().trim()

}

fun Fragment.requestpermissions(

   request: ActivityResultLauncher<Array<String>>,

   permissions: Array<String>

){


   request.launch(permissions)

}
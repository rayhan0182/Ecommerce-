package com.example.ecommerce

import android.widget.EditText

fun EditText.isemptyy(): Boolean{

   return if (this.text.isEmpty()){

        this.error = "please fillup all input box"
       true

    }else{

        false
    }

}
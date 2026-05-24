package com.example.ecommerce.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.DialogFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
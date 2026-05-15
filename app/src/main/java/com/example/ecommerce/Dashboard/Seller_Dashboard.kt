package com.example.ecommerce.Dashboard

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.ActivitySellerDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Seller_Dashboard : AppCompatActivity() {
    lateinit var binding: ActivitySellerDashboardBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentContainerView2)

        val appbarConfigure = AppBarConfiguration(setOf(

            R.id.Product,

            R.id.Upload,

            R.id.Profile

        ))

        binding.bottomNavi.setupWithNavController(navController)

        setupActionBarWithNavController(navController,appbarConfigure)
    }
}
package com.example.ecommerce.Dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
import com.example.ecommerce.activity.MainActivity
import com.example.ecommerce.databinding.ActivitySellerDashboardBinding
import com.example.ecommerce.view.LandingFragment
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Seller_Dashboard : AppCompatActivity() {
    lateinit var binding: ActivitySellerDashboardBinding
    lateinit var navController: NavController

    @Inject
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentContainerView2)

        val appconfiguration = AppBarConfiguration(setOf(

            R.id.Product,

            R.id.Upload,

            R.id.Profile

        ))

       binding.bottomNavi.setupWithNavController(navController)

       setupActionBarWithNavController(navController,appconfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

        R.id.setting->{

            Toast.makeText(this@Seller_Dashboard,"setting successfull created", Toast.LENGTH_LONG).show()

        }

            R.id.logout->{

                auth.signOut()

                startActivity(Intent(this@Seller_Dashboard, MainActivity::class.java))



            }

            R.id.report->{

                Toast.makeText(this@Seller_Dashboard,"Report successfull created", Toast.LENGTH_LONG).show()

            }

        }
        
        return super.onOptionsItemSelected(item)
    }


}
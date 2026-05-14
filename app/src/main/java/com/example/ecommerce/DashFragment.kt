package com.example.ecommerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.basefrag.BaseFragment
import com.example.ecommerce.databinding.FragmentDashBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashFragment : BaseFragment<FragmentDashBinding>(

    FragmentDashBinding::inflate


) {

    override fun user_create() {

        logout()


    }

    private fun logout() {

        with(binding){

            logout.setOnClickListener {

                FirebaseAuth.getInstance().signOut()

                findNavController().navigate(R.id.action_dashFragment_to_landingFragment)

            }


        }
    }

    override fun user_respons() {



    }


}
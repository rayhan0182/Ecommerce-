package com.example.ecommerce.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.basefrag.BaseFragment
import com.example.ecommerce.databinding.FragmentLandingBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingFragment : BaseFragment<FragmentLandingBinding>(

    FragmentLandingBinding::inflate

) {


    override fun user_create() {

        currentuser()

        with(binding){

         clickLogin.setOnClickListener {

             findNavController().navigate(R.id.action_landingFragment_to_loginFragment)
         }

            clickReg.setOnClickListener {

                findNavController().navigate(R.id.action_landingFragment_to_regFragment)
            }

        }

    }

    private fun currentuser() {

        FirebaseAuth.getInstance().currentUser?.let {

            findNavController().navigate(R.id.action_landingFragment_to_dashFragment)

        }

    }

    override fun user_respons() {

    }


}
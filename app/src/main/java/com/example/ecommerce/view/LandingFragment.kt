package com.example.ecommerce.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.Dashboard.Seller_Dashboard
import com.example.ecommerce.R
import com.example.ecommerce.basefrag.BaseFragment
import com.example.ecommerce.databinding.FragmentLandingBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LandingFragment : BaseFragment<FragmentLandingBinding>(

    FragmentLandingBinding::inflate

) {

    @Inject

    lateinit var jauth: FirebaseAuth


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

        jauth.currentUser?.let {

          startActivity(Intent(requireContext(), Seller_Dashboard::class.java))

            requireActivity().finish()

        }

    }

    override fun user_respons() {

    }


}
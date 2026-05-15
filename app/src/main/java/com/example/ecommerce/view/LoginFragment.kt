package com.example.ecommerce.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.Dashboard.Seller_Dashboard
import com.example.ecommerce.DataState
import com.example.ecommerce.R
import com.example.ecommerce.basefrag.BaseFragment
import com.example.ecommerce.data.model.Loginmodel
import com.example.ecommerce.data.viewmodel.Userviewmodel
import com.example.ecommerce.databinding.FragmentLoginBinding
import com.example.ecommerce.isemptyy
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(

    FragmentLoginBinding::inflate

) {

    private val viewmodel: Userviewmodel by viewModels()

    override fun user_create() {

        with(binding) {


            clickBtn.setOnClickListener {

                if (!email.isemptyy() && !pass.isemptyy()) {

                    val logindata = Loginmodel(email.text.toString(), pass.text.toString())

                    viewmodel.user_login(logindata)

                }


            }

            NoAcc.setOnClickListener {

                findNavController().navigate(R.id.action_loginFragment_to_regFragment)

            }


        }

    }

    override fun user_respons() {

        viewmodel.login_success_massage.observe(viewLifecycleOwner) {

            when (it) {
                is DataState.Error -> {

                    loading.dismiss()

                    Toast.makeText(requireContext(), "$it", Toast.LENGTH_LONG).show()
                }

                is DataState.Loading -> {

                    loading.show()

                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_LONG).show()

                }

                is DataState.Success -> {

                    loading.dismiss()

                    Toast.makeText(requireContext(), "successfull Login", Toast.LENGTH_LONG).show()

                    startActivity(Intent(requireContext(), Seller_Dashboard::class.java))

                    requireActivity().finish()
                    

                }
            }


        }

    }


}
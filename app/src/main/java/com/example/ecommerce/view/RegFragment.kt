package com.example.ecommerce.view

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
import com.example.ecommerce.data.model.Regmodel
import com.example.ecommerce.data.viewmodel.Userviewmodel
import com.example.ecommerce.databinding.FragmentRegBinding
import com.example.ecommerce.isemptyy
import com.google.android.play.core.integrity.v
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegFragment : BaseFragment<FragmentRegBinding>(

    FragmentRegBinding::inflate

) {

    private val viewmodel : Userviewmodel by viewModels()


    override fun user_create() {

        with(binding){

            clickBtn.setOnClickListener {

                if (!name.isemptyy()&&!email.isemptyy()&&!pass.isemptyy()){

                    val userreg = Regmodel(name = name.text.toString(), email = email.text.toString(),

                        pass = pass.text.toString(), userId = "", usertype = "seller" )

                    viewmodel.create_regis(userreg)
                }

            }

           haveAcc.setOnClickListener {

               findNavController().navigate(R.id.action_regFragment_to_loginFragment)

           }

        }

    }

    override fun user_respons() {


        viewmodel.regis_success_massage.observe(viewLifecycleOwner){it->

            when(it){
                is DataState.Error -> {

                    loading.dismiss()

                    Toast.makeText(requireContext(),"$it", Toast.LENGTH_LONG).show()
                }
                is DataState.Loading-> {

                    loading.show()

                    Toast.makeText(requireContext(),"Loading...", Toast.LENGTH_LONG).show()

                }
                is DataState.Success -> {

                    loading.dismiss()

                    Toast.makeText(requireContext(),"successfull add", Toast.LENGTH_LONG).show()

                    startActivity(Intent(requireContext(), Seller_Dashboard::class.java))

                    requireActivity().finish()

                }
            }


        }

    }


}
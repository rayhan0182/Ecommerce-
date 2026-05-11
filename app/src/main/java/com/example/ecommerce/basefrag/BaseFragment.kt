package com.example.ecommerce.basefrag
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Vb: ViewBinding>(
    //Higher order function
    private val layoutinflate:(inflate: LayoutInflater)->Vb

): Fragment() {

    private var _binding:Vb? = null

    val binding:Vb get() = _binding as Vb

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = layoutinflate.invoke(inflater)

        return binding.root

    }


}
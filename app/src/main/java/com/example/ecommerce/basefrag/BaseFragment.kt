package com.example.ecommerce.basefrag
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Vb: ViewBinding>(
    //Higher order function
    private val layoutinflate:(inflate: LayoutInflater)->Vb

): Fragment() {

    private var _binding:Vb? = null

    val binding:Vb get() = _binding as Vb

    lateinit var loading : ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = layoutinflate.invoke(inflater)

        loading = ProgressDialog(requireContext())

        user_create()

        user_respons()

        return binding.root

    }

    abstract fun user_create()

    abstract fun user_respons()

}
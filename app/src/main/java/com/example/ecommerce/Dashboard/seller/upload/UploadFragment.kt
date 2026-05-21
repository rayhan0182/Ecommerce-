package com.example.ecommerce.Dashboard.seller.upload
import android.os.Build
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.ecommerce.Dashboard.seller.Model.Pmodel
import com.example.ecommerce.basefrag.BaseFragment
import com.example.ecommerce.core.extrasyntex
import com.example.ecommerce.core.requestpermissions
import com.example.ecommerce.databinding.FragmentUploadBinding
import dagger.hilt.android.AndroidEntryPoint
import android.Manifest
import android.app.Activity
import androidx.activity.result.ActivityResult
import com.github.dhaval2404.imagepicker.ImagePicker

@AndroidEntryPoint
class UploadFragment : BaseFragment<FragmentUploadBinding>(

    FragmentUploadBinding::inflate

) {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun user_create() {

        activityResultLauncher  = getrequestpermissions()



        binding.apply {

            image.setOnClickListener {

                requestpermissions(activityResultLauncher,requestlist)

            }

            clickBtn.setOnClickListener {

                val product_name = this.pname.extrasyntex()

                val product_price = this.price.extrasyntex()

                val des = this.des.extrasyntex()

                val userdata = Pmodel(
                    product_name = product_name, imagelink = "",

                    price = product_price.toDoubleOrNull(), des = des, sellerId = "", productId = ""

                )

            }

        }

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun getrequestpermissions(): ActivityResultLauncher<Array<String>> {

       return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){result ->

           val allGranted = result.values.all { it }

            if (allGranted){

                ImagePicker.with(this)
                    .compress(1024)
                    .maxResultSize(512, 512)
                    .createIntent { intent ->
                        startForProfileImageResult.launch(intent)
                    }

            }else{

                Toast.makeText(requireContext(),"Not granted", Toast.LENGTH_LONG).show()
            }

        }


    }

    override fun user_respons() {


    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

                binding.image.setImageURI(fileUri)

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

    companion object{

        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        private val requestlist = arrayOf(

            Manifest.permission.READ_EXTERNAL_STORAGE,

            Manifest.permission.CAMERA

        )

    }

    lateinit var activityResultLauncher: ActivityResultLauncher<Array<String>>

}
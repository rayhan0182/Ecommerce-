package com.example.ecommerce.data.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerce.DataState
import com.example.ecommerce.data.model.Loginmodel
import com.example.ecommerce.data.model.Regmodel
import com.example.ecommerce.data.repo.Authrepo
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class Userviewmodel @Inject constructor(private val authrepo: Authrepo) : ViewModel() {

    private val _regis_success_massage = MutableLiveData<DataState<Regmodel>>()

    val regis_success_massage: LiveData<DataState<Regmodel>> = _regis_success_massage

    private val _login_success_massage = MutableLiveData<DataState<Loginmodel>>()

    val login_success_massage: LiveData<DataState<Loginmodel>> = _login_success_massage

    fun create_regis(ureg: Regmodel) {

        _regis_success_massage.postValue(DataState.Loading())

        authrepo.authregis(ureg).addOnSuccessListener {

            it.user?.let { createduser ->

                ureg.userId = createduser.uid

                authrepo.create_user(ureg).addOnSuccessListener {
                    ureg

                    _regis_success_massage.postValue(DataState.Success(ureg))

                }.addOnFailureListener { exception ->

                    _regis_success_massage.postValue(DataState.Error(exception.message.toString()))

                }

            }

        }

    }

        fun user_login(loginmodel: Loginmodel) {

            _login_success_massage.postValue(DataState.Loading())

            authrepo.authlogin(loginmodel).addOnSuccessListener { loginmodel

                _login_success_massage.postValue(DataState.Success(loginmodel))

            }.addOnFailureListener { exception ->

                _login_success_massage.postValue(DataState.Error("${exception.message}"))

            }


        }

    }







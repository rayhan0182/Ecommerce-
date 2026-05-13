package com.example.ecommerce.data.authservice
import com.example.ecommerce.data.model.Loginmodel
import com.example.ecommerce.data.model.Regmodel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {

    fun authregis(regmodel: Regmodel): Task<AuthResult>

    fun authlogin(loginmodel: Loginmodel): Task<AuthResult>
}
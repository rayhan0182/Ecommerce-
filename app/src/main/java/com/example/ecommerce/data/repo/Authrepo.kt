package com.example.ecommerce.data.repo
import com.example.ecommerce.Notes
import com.example.ecommerce.data.authservice.AuthService
import com.example.ecommerce.data.model.Loginmodel
import com.example.ecommerce.data.model.Regmodel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject

class Authrepo @Inject constructor(

    private val firebaseAuth: FirebaseAuth,private val firestore: FirebaseFirestore

): AuthService {
    
    override fun authregis(regmodel: Regmodel): Task<AuthResult> {

     return firebaseAuth.createUserWithEmailAndPassword(regmodel.email,regmodel.pass)

    }

    override fun authlogin(loginmodel: Loginmodel): Task<AuthResult> {

      return  firebaseAuth.signInWithEmailAndPassword(loginmodel.email,loginmodel.pass)

    }

    override fun create_user(regmodel: Regmodel): Task<Void> {

     return  firestore.collection(Notes.userfirestore)

           .document(regmodel.userId).set(regmodel)

    }
}
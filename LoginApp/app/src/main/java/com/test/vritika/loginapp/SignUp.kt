package com.test.vritika.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()

        Signup.setOnClickListener{
            signUpUser()
        }
    }

    private fun signUpUser(){
        if(email1.text.toString().isEmpty()){
            email1.error="Please enter email"
            email1.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email1.text.toString()).matches()){
            email1.error="Please enter a valid email"
            email1.requestFocus()
            return
        }

        if(password1.text.toString().isEmpty()){
            password1.error = "Please enter password"
            password1.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email1.text.toString(), password1.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user : FirebaseUser? = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener{
                            if(task.isSuccessful){
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }

                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try Later.",
                    Toast.LENGTH_SHORT).show()
                }
            }
    }
}
